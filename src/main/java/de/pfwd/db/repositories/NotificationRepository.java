package de.pfwd.db.repositories;

import de.pfwd.db.entities.NotificationEntity;
import de.pfwd.db.entities.mappers.NotificationEntityMapper;
import de.pfwd.service.notification.NotificationSeverity;
import de.pfwd.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface NotificationRepository {

  @SqlQuery("""
          SELECT 
            n.subject, n.message, n.creation_date, s."name"  AS "severity"
          FROM 
            notifications n
          JOIN notification_severities s
            ON n.severity_id = s.id
          ORDER BY n.severity_id
      """)
  @RegisterRowMapper(NotificationEntityMapper.class)
  List<NotificationEntity> retrieveNotifications();


  @SqlUpdate("""
          INSERT INTO notifications
            (subject, message, creation_date, severity_id, system_event_id)
          VALUES
            (
            	:subject, :message, :creationDate,
            	(SELECT id FROM notification_severities WHERE name = :severity),
            	:systemEventId
            )
      """)
  void createNotification(@Bind("subject") String subject, @Bind("message") String message,
      @Bind("creationDate") OffsetDateTime creationDate,
      @Bind("severity") NotificationSeverity severity,
      @Bind("systemEventId") Integer systemEventId);
}
