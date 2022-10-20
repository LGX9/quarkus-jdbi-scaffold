package de.pfwd.scaffold.quarkusjdbi.service.mappers;

import de.pfwd.scaffold.quarkusjdbi.persist.entities.NotificationEntity;
import de.pfwd.scaffold.quarkusjdbi.service.notification.NotificationSeverity;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO;
import io.quarkus.test.junit.QuarkusTest;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class NotificationMapperTest {

    @Inject NotificationMapper notificationMapper;

    @Test
    public void notificationMapper_EntityToDTO_ok() {
        NotificationEntity entity =
                new NotificationEntity(
                        1L,
                        UUID.randomUUID(),
                        "TestSubject",
                        "TestMessage",
                        OffsetDateTime.now(),
                        NotificationSeverity.ALARM.name());
        ResponseDTO.NotificationResponseDTO dto = notificationMapper.entityToDto(entity);
        Assertions.assertEquals(entity.getUuid(), dto.uuid());
    }
}
