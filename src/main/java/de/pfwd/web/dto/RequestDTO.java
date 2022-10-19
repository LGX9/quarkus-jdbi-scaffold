package de.pfwd.web.dto;

import de.pfwd.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.Map;

public class RequestDTO {

    public record SystemEventRequestDTO(
            SystemEventType eventType, Map<String, String> payload, OffsetDateTime creationDate) {}
}
