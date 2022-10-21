package de.pfwd.scaffold.quarkusjdbi.service.system;

import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemRepository;
import de.pfwd.scaffold.quarkusjdbi.service.mappers.SystemMapper;
import de.pfwd.scaffold.quarkusjdbi.web.dto.RequestDTO;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SystemService {

    @Inject SystemRepository systemRepository;

    @Inject SystemMapper systemMapper;

    public List<ResponseDTO.SystemResponseDTO> retrieveSystems() {
        return systemRepository.retrieveSystems().stream()
                .map(it -> systemMapper.entityToDto(it))
                .toList();
    }

    public void createSystem(RequestDTO.SystemCreateRequestDTO system) {
        systemRepository.createSystem(UUID.randomUUID(), system.name(), SystemStatusType.UNKNOWN);
    }
}
