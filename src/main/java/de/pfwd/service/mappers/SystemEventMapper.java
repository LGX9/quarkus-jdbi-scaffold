package de.pfwd.service.mappers;

import de.pfwd.db.entities.SystemEventEntity;
import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.web.dto.ResponseDTO.SystemEventResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SystemEventMapper {
  SystemEventResponseDTO entityToDto(SystemEventEntity entity);
  SystemEventEntity dtoToEntity(SystemEventRequestDTO dto);
}
