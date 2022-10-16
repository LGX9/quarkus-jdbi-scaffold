package de.pfwd.service;

import de.pfwd.db.entities.SystemEventEntity;
import de.pfwd.db.repositories.SystemEventRepository;
import de.pfwd.service.mappers.SystemEventMapper;
import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import java.time.OffsetDateTime;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jdbi.v3.postgres.HStore;

@Singleton
public class SystemEventService {

  @Inject
  SystemEventRepository systemEventRepository;

  @Inject
  NotificationService notificationService;

  @Inject
  SystemEventMapper systemEventMapper;

  public void createSystemEvent(SystemEventRequestDTO event) {
    systemEventRepository.createSystemEvent(event.eventType(), event.payload(), event.creationDate(),
        OffsetDateTime.now());

    switch (event.eventType().getSeverity()) {
      case WARNING, ALARM ->  notificationService.createSystemEventNotification(event);
    }
  }

}
