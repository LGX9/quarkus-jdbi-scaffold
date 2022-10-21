package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import de.pfwd.scaffold.quarkusjdbi.service.system.SystemStatusType;
import java.util.UUID;

public class SystemEntity {

    Long id;

    UUID uuid;

    String name;

    SystemStatusType status;

    public SystemEntity(Long id, UUID uuid, String name, SystemStatusType status) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SystemStatusType getStatus() {
        return status;
    }

    public void setStatus(SystemStatusType status) {
        this.status = status;
    }
}
