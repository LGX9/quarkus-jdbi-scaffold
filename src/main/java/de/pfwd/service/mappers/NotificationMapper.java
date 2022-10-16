package de.pfwd.service.mappers;

import de.pfwd.db.entities.NotificationEntity;
import de.pfwd.web.dto.ResponseDTO.NotificationResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface NotificationMapper {
  NotificationResponseDTO entityToDto(NotificationEntity entity);
}
