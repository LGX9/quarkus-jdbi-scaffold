package de.pfwd.db.entities;

import de.pfwd.service.systemevent.SystemEventType;
import java.time.OffsetDateTime;
import java.util.Map;

public class SystemEventEntity {

  SystemEventType eventType;

  Map<String, String> payload;

  OffsetDateTime creationDate;

  OffsetDateTime receivedDate;

  public SystemEventEntity(SystemEventType eventType,
      Map<String, String> payload, OffsetDateTime creationDate, OffsetDateTime receivedDate) {
    this.eventType = eventType;
    this.payload = payload;
    this.creationDate = creationDate;
    this.receivedDate = receivedDate;
  }

  public SystemEventType getEventType() {
    return eventType;
  }

  public Map<String, String> getPayload() {
    return payload;
  }

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public OffsetDateTime getReceivedDate() {
    return receivedDate;
  }

  public void setEventType(SystemEventType eventType) {
    this.eventType = eventType;
  }

  public void setPayload(Map<String, String> payload) {
    this.payload = payload;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public void setReceivedDate(OffsetDateTime receivedDate) {
    this.receivedDate = receivedDate;
  }
}
