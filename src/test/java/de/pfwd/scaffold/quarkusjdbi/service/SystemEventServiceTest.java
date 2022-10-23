package de.pfwd.scaffold.quarkusjdbi.service;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.SystemEventEntity;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemEventRepository;
import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventService;
import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class SystemEventServiceTest {

    @Inject SystemEventService systemEventService;

    @InjectMock SystemEventRepository systemEventRepository;

    @Test
    public void retrieveSystemEvents_ok() {
        Mockito.when(systemEventRepository.retrieveSystemEvents())
                .thenReturn(
                        List.of(
                                new SystemEventEntity(
                                        1L,
                                        UUID.randomUUID(),
                                        SystemEventType.SYSTEM_PAUSED,
                                        new HashMap<>(),
                                        OffsetDateTime.now(),
                                        OffsetDateTime.now(),
                                        UUID.randomUUID()),
                                new SystemEventEntity(
                                        2L,
                                        UUID.randomUUID(),
                                        SystemEventType.SYSTEM_CRASH,
                                        new HashMap<>(),
                                        OffsetDateTime.now(),
                                        OffsetDateTime.now(),
                                        UUID.randomUUID())));
        Assertions.assertEquals(2, systemEventService.retrieveSystemEvents().size());
    }
}
