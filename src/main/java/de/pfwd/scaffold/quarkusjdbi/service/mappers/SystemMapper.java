package de.pfwd.scaffold.quarkusjdbi.service.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEntity;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SystemMapper {

    ResponseDTO.SystemResponseDTO entityToDto(SystemEntity entity);
}
