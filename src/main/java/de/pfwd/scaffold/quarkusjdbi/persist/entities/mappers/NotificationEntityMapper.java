package de.pfwd.scaffold.quarkusjdbi.persist.entities.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.NotificationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class NotificationEntityMapper implements RowMapper<NotificationEntity> {

    @Override
    public NotificationEntity map(ResultSet rs, StatementContext ctx) throws SQLException {
        String subject = rs.getString("subject");
        String message = rs.getString("message");
        OffsetDateTime creationDate =
                OffsetDateTime.ofInstant(
                        rs.getTimestamp("creation_date").toInstant(), ZoneId.of("UTC"));
        String severity = rs.getString("severity");

        return new NotificationEntity(subject, message, creationDate, severity);
    }
}
