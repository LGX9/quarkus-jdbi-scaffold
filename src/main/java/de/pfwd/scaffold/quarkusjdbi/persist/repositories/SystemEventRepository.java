package de.pfwd.scaffold.quarkusjdbi.persist.repositories;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEventEntity;
import de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers.SystemEventEntityMapper;
import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SystemEventRepository {

    // spotless:off
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
    // spotless:on
    @RegisterRowMapper(SystemEventEntityMapper.class)
    List<SystemEventEntity> retrieveSystemEvents();

    // spotless:off
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
    // spotless:on
    Integer createSystemEvent(
            @Bind("eventType") SystemEventType eventType,
            @Bind("payload") String payload,
            @Bind("creationDate") OffsetDateTime creationDate,
            @Bind("receivedDate") OffsetDateTime receivedDate);
}
