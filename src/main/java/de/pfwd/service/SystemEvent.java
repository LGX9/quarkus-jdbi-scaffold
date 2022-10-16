package de.pfwd.service;


public enum SystemEvent {

  SYSTEM_INITIALIZED(SystemEventSeverity.INFO),
  SYSTEM_DEACTIVATED(SystemEventSeverity.INFO),
  SYSTEM_PAUSED(SystemEventSeverity.INFO),
  HEARTBEAT(SystemEventSeverity.INFO),

  TEMPERATURE_TOO_HOT(SystemEventSeverity.WARNING),
  TEMPERATURE_TOO_COLD(SystemEventSeverity.WARNING),
  DISK_SPACE_ALMOST_FULL(SystemEventSeverity.WARNING),

  FAN_MALFUNCTION(SystemEventSeverity.ALARM),
  NO_MORE_DISKSPACE(SystemEventSeverity.ALARM),
  SYSTEM_CRASH(SystemEventSeverity.ALARM);

  private SystemEventSeverity severity;

  SystemEvent(SystemEventSeverity severity) {
    this.severity = severity;
  }

  public SystemEventSeverity getSeverity() {
    return this.severity;
  }

}
