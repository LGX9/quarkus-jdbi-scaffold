package de.pfwd.service;

import de.pfwd.db.repositories.NotificationRepository;
import de.pfwd.service.mappers.NotificationMapper;

import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.web.dto.ResponseDTO.NotificationResponseDTO;
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
    return notificationRepository.listNotifications().stream()
        .map(it -> notificationMapper.entityToDto(it))
        .toList();
  }

  public void createSystemEventNotification(SystemEventRequestDTO systemEvent) {

  }
}
