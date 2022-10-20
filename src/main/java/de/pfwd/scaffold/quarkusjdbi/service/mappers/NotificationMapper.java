package de.pfwd.scaffold.quarkusjdbi.service.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.NotificationEntity;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO.NotificationResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface NotificationMapper {
    NotificationResponseDTO entityToDto(NotificationEntity entity);
}
