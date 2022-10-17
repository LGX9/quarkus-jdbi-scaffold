package de.pfwd.service.notification;

import de.pfwd.db.repositories.NotificationRepository;
import de.pfwd.service.mappers.NotificationMapper;
import de.pfwd.service.systemevent.SystemEventType;
import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.web.dto.ResponseDTO.NotificationResponseDTO;
import java.time.OffsetDateTime;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NotificationService {

  @Inject
  NotificationRepository notificationRepository;

  @Inject
  NotificationMapper notificationMapper;

  public List<NotificationResponseDTO> retrieveNotifications() {
    return notificationRepository.retrieveNotifications().stream()
        .map(it -> notificationMapper.entityToDto(it))
        .toList();
  }

  public void createSystemEventNotification(SystemEventRequestDTO systemEvent,
      NotificationSeverity notificationSeverity, Integer systemEventId) {
    notificationRepository.createNotification("Random Subject ... Important!",
        "This happened: " + systemEvent.eventType(), OffsetDateTime.now(), notificationSeverity, systemEventId);
  }

  public NotificationSeverity getNotificationSeverity(SystemEventType systemEventType) {
    switch (systemEventType) {
      case SYSTEM_INITIALIZED,
          SYSTEM_DEACTIVATED,
          SYSTEM_PAUSED,
          HEARTBEAT -> {
        return NotificationSeverity.INFO;
      }
      case TEMPERATURE_TOO_HOT,
          TEMPERATURE_TOO_COLD,
          DISK_SPACE_ALMOST_FULL -> {
        return NotificationSeverity.WARNING;
      }
      case FAN_MALFUNCTION,
          NO_MORE_DISKSPACE,
          SYSTEM_CRASH -> {
        return NotificationSeverity.ALARM;
      }
      default -> throw new UnsupportedOperationException(
          "SystemEventType unknown: " + systemEventType);
    }
  }
}
