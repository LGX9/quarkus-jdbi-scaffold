package de.pfwd.web.dto;

import de.pfwd.service.SystemEvent;
import java.time.OffsetDateTime;
import java.util.Map;

public class RequestDTO {

  public record SystemEventRequestDTO(SystemEvent eventType, Map<String, String> payload,
                                      OffsetDateTime creationDate) {}


}
