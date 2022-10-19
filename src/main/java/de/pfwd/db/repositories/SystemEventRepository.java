package de.pfwd.db.repositories;

import de.pfwd.db.entities.SystemEventEntity;
import de.pfwd.db.entities.mappers.SystemEventEntityMapper;
import de.pfwd.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SystemEventRepository {

    @SqlQuery(
    """
      SELECT
        setypes.name AS event_type, se.payload, se.creation_date, se.received_date
      FROM
        system_events se
      JOIN
        system_event_types setypes ON setypes.id = se.system_event_type_id
      ORDER BY se.id
    """)
    @RegisterRowMapper(SystemEventEntityMapper.class)
    List<SystemEventEntity> retrieveSystemEvents();

    @SqlUpdate(
    """
      INSERT INTO system_events
        (system_event_type_id, payload, creation_date, received_date)
      VALUES
        (
          (SELECT id FROM system_event_types WHERE name = :eventType),
          CAST(:payload as jsonb),
          :creationDate,
          :receivedDate
        )
    """)
    Integer createSystemEvent(
            @Bind("eventType") SystemEventType eventType,
            @Bind("payload") String payload,
            @Bind("creationDate") OffsetDateTime creationDate,
            @Bind("receivedDate") OffsetDateTime receivedDate);
}
