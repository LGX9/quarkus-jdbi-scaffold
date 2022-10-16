package de.pfwd.db.entities;

import java.time.OffsetDateTime;
import java.util.Map;

public class SystemEventEntity {

  String eventType;

  Map<String, Object> payload;

  OffsetDateTime creationDate;

  OffsetDateTime receivedDate;

  public SystemEventEntity(String eventType,
      Map<String, Object> payload, OffsetDateTime creationDate, OffsetDateTime receivedDate) {
    this.eventType = eventType;
    this.payload = payload;
    this.creationDate = creationDate;
    this.receivedDate = receivedDate;
  }

  public String getEventType() {
    return eventType;
  }

  public Map<String, Object> getPayload() {
    return payload;
  }

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public OffsetDateTime getReceivedDate() {
    return receivedDate;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public void setPayload(Map<String, Object> payload) {
    this.payload = payload;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public void setReceivedDate(OffsetDateTime receivedDate) {
    this.receivedDate = receivedDate;
  }
}
