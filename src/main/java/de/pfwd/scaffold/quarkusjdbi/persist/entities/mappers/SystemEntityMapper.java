package de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEntity;
import de.pfwd.scaffold.quarkusjdbi.service.system.SystemStatusType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class SystemEntityMapper implements RowMapper<SystemEntity> {

    @Override
    public SystemEntity map(ResultSet rs, StatementContext ctx) throws SQLException {
        Long id = rs.getLong("id");
        UUID uuid = UUID.fromString(rs.getString("uuid"));
        String name = rs.getString("name");
        SystemStatusType status = SystemStatusType.valueOf(rs.getString("status"));

        return new SystemEntity(id, uuid, name, status);
    }
}
