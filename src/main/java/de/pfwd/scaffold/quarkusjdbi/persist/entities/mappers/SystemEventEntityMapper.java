package de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEventEntity;
import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import io.quarkus.logging.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.postgresql.util.PGobject;

public class SystemEventEntityMapper implements RowMapper<SystemEventEntity> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SystemEventEntity map(ResultSet rs, StatementContext ctx) throws SQLException {

        Long id = rs.getLong("id");
        UUID uuid = UUID.fromString(rs.getString("uuid"));
        SystemEventType eventType = SystemEventType.valueOf(rs.getString("event_type"));

        PGobject payload = ((PGobject) rs.getObject("payload"));
        Map<String, String> payloadMap = null;
        try {
            payloadMap = objectMapper.readValue(payload.getValue(), Map.class);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
            payloadMap = new HashMap<>();
        }

        OffsetDateTime creationDate =
                OffsetDateTime.ofInstant(
                        rs.getTimestamp("creation_date").toInstant(), ZoneId.of("UTC"));

        OffsetDateTime receivedDate =
                OffsetDateTime.ofInstant(
                        rs.getTimestamp("received_date").toInstant(), ZoneId.of("UTC"));

        UUID systemUUID = UUID.fromString(rs.getString("system_uuid"));

        return new SystemEventEntity(
                id, uuid, eventType, payloadMap, creationDate, receivedDate, systemUUID);
    }
}
