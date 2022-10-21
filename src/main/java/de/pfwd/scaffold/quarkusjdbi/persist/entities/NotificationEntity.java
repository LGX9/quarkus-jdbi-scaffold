package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class NotificationEntity {

    Long id;

    UUID uuid;

    String subject;

    String message;

    OffsetDateTime creationDate;

    String severity;

}
