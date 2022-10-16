package de.pfwd.db.repositories;

import de.pfwd.db.entities.NotificationEntity;
import de.pfwd.db.entities.mappers.NotificationEntityMapper;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

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
  List<NotificationEntity> listNotifications();
}
