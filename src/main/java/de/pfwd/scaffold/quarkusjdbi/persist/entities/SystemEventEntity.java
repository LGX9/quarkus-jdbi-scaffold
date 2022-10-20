package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

public class SystemEventEntity {

    Long id;

    UUID uuid;
    SystemEventType eventType;

    Map<String, String> payload;

    OffsetDateTime creationDate;

    OffsetDateTime receivedDate;

    public SystemEventEntity(
            Long id,
            UUID uuid,
            SystemEventType eventType,
            Map<String, String> payload,
            OffsetDateTime creationDate,
            OffsetDateTime receivedDate) {
        this.id = id;
        this.uuid = uuid;
        this.eventType = eventType;
        this.payload = payload;
        this.creationDate = creationDate;
        this.receivedDate = receivedDate;
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public SystemEventType getEventType() {
        return eventType;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public OffsetDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setEventType(SystemEventType eventType) {
        this.eventType = eventType;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setReceivedDate(OffsetDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }
}
