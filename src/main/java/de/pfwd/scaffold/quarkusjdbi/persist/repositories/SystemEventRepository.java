package de.pfwd.scaffold.quarkusjdbi.persist.repositories;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEventEntity;
import de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers.SystemEventEntityMapper;
import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SystemEventRepository {

    // spotless:off
    @SqlQuery(
    """
      SELECT
        se.id, se.uuid, setypes.name AS event_type, se.payload, se.creation_date, se.received_date, s.uuid as system_uuid
      FROM
        system_events se
      JOIN
        system_event_types setypes ON setypes.id = se.system_event_type_id
      JOIN
        systems s on s.id = se.system_id
      ORDER BY se.id
      LIMIT 1000
    """)
    // spotless:on
    @RegisterRowMapper(SystemEventEntityMapper.class)
    List<SystemEventEntity> retrieveSystemEvents();

    // spotless:off
    @SqlQuery(
            """
              SELECT
                se.id, se.uuid, setypes.name AS event_type, se.payload, se.creation_date, se.received_date, s.uuid as system_uuid
              FROM
                system_events se
              JOIN
                system_event_types setypes ON setypes.id = se.system_event_type_id
              JOIN
                systems s on s.id = se.system_id
              WHERE 
                s.uuid = :systemUUID
              ORDER BY se.id
              LIMIT 1000
            """)
    // spotless:on
    @RegisterRowMapper(SystemEventEntityMapper.class)
    List<SystemEventEntity> retrieveSystemEventsFromSystem(@Bind("systemUUID") UUID systemUUID);

    // spotless:off
    @SqlUpdate(
    """
      INSERT INTO system_events
        (uuid, system_event_type_id, payload, creation_date, received_date, system_id)
      VALUES
        (
          :uuid,
          (SELECT id FROM system_event_types WHERE name = :eventType),
          CAST(:payload as jsonb),
          :creationDate,
          :receivedDate,
          (SELECT id FROM systems WHERE uuid = :systemUUID)
        )
    """)
    // spotless:on
    @GetGeneratedKeys
    Long createSystemEvent(
            @Bind("uuid") UUID uuid,
            @Bind("eventType") SystemEventType eventType,
            @Bind("payload") String payload,
            @Bind("creationDate") OffsetDateTime creationDate,
            @Bind("receivedDate") OffsetDateTime receivedDate,
            @Bind("systemUUID") UUID systemUUID);

    // spotless:off
    @SqlUpdate(
    """
        WITH systemEventToDelete as (
             SELECT id FROM 
                system_events
             WHERE
                uuid = :uuid
        ),
        notificationDeletes AS (
            DELETE FROM notifications
                WHERE system_event_id 
                    IN (SELECT * FROM systemEventToDelete)
        )
        DELETE FROM system_events 
            WHERE id IN (SELECT * FROM systemEventToDelete)
    """
    )
    // spotless:on
    public void deleteByUUID(@Bind("uuid") UUID uuid);
}
