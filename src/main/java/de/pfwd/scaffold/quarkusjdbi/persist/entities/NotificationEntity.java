package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

public class NotificationEntity {

    Long id;

    UUID uuid;
    String subject;

    String message;

    OffsetDateTime creationDate;

    String severity;

    public NotificationEntity(
            Long id,
            UUID uuid,
            String subject,
            String message,
            OffsetDateTime creationDate,
            String severity) {
        this.id = id;
        this.uuid = uuid;
        this.subject = subject;
        this.message = message;
        this.creationDate = creationDate;
        this.severity = severity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "NotificationEntity{"
                + "subject='"
                + subject
                + '\''
                + ", message='"
                + message
                + '\''
                + ", creationDate="
                + creationDate
                + ", severity='"
                + severity
                + '\''
                + '}';
    }
}
