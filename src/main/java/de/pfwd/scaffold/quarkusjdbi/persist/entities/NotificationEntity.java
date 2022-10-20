package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import java.time.OffsetDateTime;

public class NotificationEntity {

    String subject;

    String message;

    OffsetDateTime creationDate;

    String severity;

    public NotificationEntity(
            String subject, String message, OffsetDateTime creationDate, String severity) {
        this.subject = subject;
        this.message = message;
        this.creationDate = creationDate;
        this.severity = severity;
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
