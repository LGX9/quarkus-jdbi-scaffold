package de.pfwd.scaffold.quarkusjdbi.service.systemevent;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemEventRepository;
import de.pfwd.scaffold.quarkusjdbi.service.mappers.SystemEventMapper;
import de.pfwd.scaffold.quarkusjdbi.service.notification.NotificationService;
import de.pfwd.scaffold.quarkusjdbi.service.notification.NotificationSeverity;
import de.pfwd.scaffold.quarkusjdbi.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO.SystemEventResponseDTO;
import io.quarkus.logging.Log;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SystemEventService {

    @Inject SystemEventRepository systemEventRepository;

    @Inject NotificationService notificationService;

    @Inject SystemEventMapper systemEventMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<SystemEventResponseDTO> retrieveSystemEvents() {
        return systemEventRepository.retrieveSystemEvents().stream()
                .map(it -> systemEventMapper.entityToDto(it))
                .toList();
    }

    public void createSystemEvent(SystemEventRequestDTO event) {
        String payloadString = null;
        try {
            payloadString = objectMapper.writeValueAsString(event.payload());
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        Long systemEventId =
                systemEventRepository.createSystemEvent(
                        UUID.randomUUID(),
                        event.eventType(),
                        payloadString,
                        event.creationDate(),
                        OffsetDateTime.now());
        Log.infov("Stored event: {0}", event.eventType().toString());

        NotificationSeverity severity =
                notificationService.getNotificationSeverity(event.eventType());
        if (severity == NotificationSeverity.ALARM || severity == NotificationSeverity.WARNING) {
            notificationService.createSystemEventNotification(event, severity, systemEventId);
        }
    }

    public void deleteSystemEventByUUID(UUID uuid) {
        systemEventRepository.deleteByUUID(uuid);
    }
}
