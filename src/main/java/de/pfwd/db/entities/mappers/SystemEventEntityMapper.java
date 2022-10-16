package de.pfwd.db.entities.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.pfwd.db.entities.NotificationEntity;
import de.pfwd.db.entities.SystemEventEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class SystemEventEntityMapper implements RowMapper<SystemEventEntity> {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public SystemEventEntity map(ResultSet rs, StatementContext ctx) throws SQLException {
    String eventType = rs.getString("event_type");

    Map<String, Object> payload = new HashMap<>();
    Object object = rs.getObject("payload");

    OffsetDateTime creationDate = OffsetDateTime.ofInstant(rs.getTimestamp("creation_date").toInstant(),
        ZoneId.of("UTC"));

    OffsetDateTime receivedDate = OffsetDateTime.ofInstant(rs.getTimestamp("received_date").toInstant(),
        ZoneId.of("UTC"));

    return new SystemEventEntity(eventType, payload,  creationDate, receivedDate);

  }
}
