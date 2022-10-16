package de.pfwd.web.dto;

import java.time.OffsetDateTime;
import java.util.Map;

public class ResponseDTO {
  public record NotificationResponseDTO (String subject, String message, OffsetDateTime creationDate, String severity) {}

  public record SystemEventResponseDTO(String eventType, Map<String, Object> payload,
                                      OffsetDateTime creationDate, OffsetDateTime receivedDate) {}
}
