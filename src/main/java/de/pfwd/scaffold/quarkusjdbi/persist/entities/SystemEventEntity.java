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

    UUID systemUUID;

    public SystemEventEntity(
            Long id,
            UUID uuid,
            SystemEventType eventType,
            Map<String, String> payload,
            OffsetDateTime creationDate,
            OffsetDateTime receivedDate,
            UUID systemUUID) {
        this.id = id;
        this.uuid = uuid;
        this.eventType = eventType;
        this.payload = payload;
        this.creationDate = creationDate;
        this.receivedDate = receivedDate;
        this.systemUUID = systemUUID;
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

    public UUID getSystemUUID() {
        return systemUUID;
    }
}
