package de.pfwd.scaffold.quarkusjdbi.persist.repositories;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEntity;
import de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers.SystemEntityMapper;
import de.pfwd.scaffold.quarkusjdbi.service.system.SystemStatusType;
import java.util.List;
import java.util.UUID;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SystemRepository {

    // spotless:off
    @SqlQuery(
    """
              SELECT
                s.id, s.uuid, s.name, sst.name as status
              FROM
                systems s
              JOIN 
                system_status_types sst 
              ON s.system_status_type_id = sst.id
              ORDER BY s.id
    """)
    // spotless:on
    @RegisterRowMapper(SystemEntityMapper.class)
    List<SystemEntity> retrieveSystems();

    // spotless:off
    @SqlUpdate(
    """
              INSERT INTO systems
                (uuid, name, system_status_type_id)
              VALUES
                (
                  :uuid,
                  :name,
                  (SELECT id FROM system_status_types WHERE name = :statusType)
                )
    """)
    // spotless:on
    @GetGeneratedKeys
    Long createSystem(
            @Bind("uuid") UUID uuid,
            @Bind("name") String name,
            @Bind("statusType") SystemStatusType statusType);
}
