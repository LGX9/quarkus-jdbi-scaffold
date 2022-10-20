package de.pfwd.scaffold.quarkusjdbi.service.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEventEntity;
import de.pfwd.scaffold.quarkusjdbi.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO.SystemEventResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SystemEventMapper {
    SystemEventResponseDTO entityToDto(SystemEventEntity entity);

    SystemEventEntity dtoToEntity(SystemEventRequestDTO dto);
}
