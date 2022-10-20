package de.pfwd.scaffold.quarkusjdbi.persist.repositories;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.NotificationEntity;
import de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers.NotificationEntityMapper;
import de.pfwd.scaffold.quarkusjdbi.service.notification.NotificationSeverity;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface NotificationRepository {

    // spotless:off
    @SqlQuery(
    """
          SELECT
            n.id, n.uuid, n.subject, n.message, n.creation_date, s."name"  AS "severity"
          FROM
            notifications n
          JOIN notification_severities s
            ON n.severity_id = s.id
          ORDER BY n.severity_id
    """)
    // spotless:on
    @RegisterRowMapper(NotificationEntityMapper.class)
    List<NotificationEntity> retrieveNotifications();

    // spotless:off
    @SqlUpdate(
    """
          INSERT INTO notifications
            (uuid, subject, message, creation_date, severity_id, system_event_id)
          VALUES
            (
                :uuid,
            	:subject, :message, :creationDate,
            	(SELECT id FROM notification_severities WHERE name = :severity),
            	:systemEventId
            )
    """)
    // spotless:on
    @GetGeneratedKeys
    Long createNotification(
            @Bind("uuid") UUID uuid,
            @Bind("subject") String subject,
            @Bind("message") String message,
            @Bind("creationDate") OffsetDateTime creationDate,
            @Bind("severity") NotificationSeverity severity,
            @Bind("systemEventId") Long systemEventId);

    // spotless:off
    @SqlUpdate(
    """
        DELETE FROM notifications n
            WHERE n.uuid = :uuid
    """
    )
    // spotless:on
    public void deleteByUUID(@Bind("uuid") UUID uuid);
}
