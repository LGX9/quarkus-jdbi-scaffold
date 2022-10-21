package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;
@AllArgsConstructor
@Getter
@ToString
public class SystemEventEntity {

    Long id;

    UUID uuid;
    SystemEventType eventType;

    Map<String, String> payload;

    OffsetDateTime creationDate;

    OffsetDateTime receivedDate;

    UUID systemUUID;

}
