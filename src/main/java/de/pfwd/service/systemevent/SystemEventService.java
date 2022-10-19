package de.pfwd.service.systemevent;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.pfwd.db.repositories.SystemEventRepository;
import de.pfwd.service.mappers.SystemEventMapper;
import de.pfwd.service.notification.NotificationService;
import de.pfwd.service.notification.NotificationSeverity;
import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.web.dto.ResponseDTO.SystemEventResponseDTO;
import io.quarkus.logging.Log;
import java.time.OffsetDateTime;
import java.util.List;
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
        Integer systemEventId =
                systemEventRepository.createSystemEvent(
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
}
