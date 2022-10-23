package de.pfwd.scaffold.quarkusjdbi.persist;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEntity;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemRepository;
import de.pfwd.scaffold.quarkusjdbi.service.system.SystemStatusType;
import de.pfwd.scaffold.quarkusjdbi.testresource.PostgresResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Optional;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class SystemRepositoryTest {

    @Inject SystemRepository systemRepository;

    @Test
    public void systemrepository_createEntity_ok() {
        systemRepository.createSystem(UUID.randomUUID(), "TestSystem", SystemStatusType.OK);
    }

    @Test
    public void systemrepository_readEntity_ok() {
        UUID systemUUID = UUID.randomUUID();
        systemRepository.createSystem(systemUUID, "TestSystem", SystemStatusType.OK);
        Optional<SystemEntity> systemEntity =
                systemRepository.retrieveSystems().stream()
                        .filter(s -> s.getUuid().equals(systemUUID))
                        .findAny();
        Assertions.assertTrue(systemEntity.isPresent());
    }
}
