package de.pfwd.scaffold.quarkusjdbi.persist.entities;

import de.pfwd.scaffold.quarkusjdbi.service.system.SystemStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class SystemEntity {

    Long id;

    UUID uuid;

    String name;

    SystemStatusType status;

}
