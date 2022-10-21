package de.pfwd.scaffold.quarkusjdbi.service.systemevent;

public enum SystemEventType {
    SYSTEM_PAUSED,
    HEARTBEAT,
    TEMPERATURE_TOO_HOT,
    TEMPERATURE_TOO_COLD,
    DISK_ALMOST_FULL,
    FAN_MALFUNCTION,
    DISK_FULL,
    SYSTEM_CRASH;
}
