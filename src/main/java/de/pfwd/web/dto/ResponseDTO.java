package de.pfwd.web.dto;

import de.pfwd.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.Map;

public class ResponseDTO {
  public record NotificationResponseDTO (String subject, String message, OffsetDateTime creationDate, String severity) {}

  public record SystemEventResponseDTO(SystemEventType eventType, Map<String, String> payload,
                                       OffsetDateTime creationDate, OffsetDateTime receivedDate) {}
}
