package de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.NotificationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class NotificationEntityMapper implements RowMapper<NotificationEntity> {

    @Override
    public NotificationEntity map(ResultSet rs, StatementContext ctx) throws SQLException {
        Long id = rs.getLong("id");
        UUID uuid = UUID.fromString(rs.getString("uuid"));
        String subject = rs.getString("subject");
        String message = rs.getString("message");
        OffsetDateTime creationDate =
                OffsetDateTime.ofInstant(
                        rs.getTimestamp("creation_date").toInstant(), ZoneId.of("UTC"));
        String severity = rs.getString("severity");

        return new NotificationEntity(id, uuid, subject, message, creationDate, severity);
    }
}
