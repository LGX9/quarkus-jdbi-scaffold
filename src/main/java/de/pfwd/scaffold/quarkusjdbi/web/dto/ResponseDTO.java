package de.pfwd.scaffold.quarkusjdbi.web.dto;

import de.pfwd.scaffold.quarkusjdbi.service.system.SystemStatusType;
import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

public class ResponseDTO {
    public record NotificationResponseDTO(
            UUID uuid,
            String subject,
            String message,
            OffsetDateTime creationDate,
            String severity) {}

    public record SystemEventResponseDTO(
            UUID uuid,
            SystemEventType eventType,
            Map<String, String> payload,
            OffsetDateTime creationDate,
            OffsetDateTime receivedDate,
            UUID systemUUID) {}

    public record SystemResponseDTO(UUID uuid, String name, SystemStatusType status) {}
}
