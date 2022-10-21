CREATE TABLE IF NOT EXISTS system_status_types (
   id serial PRIMARY KEY,
   name varchar(255) UNIQUE
);

INSERT INTO
    system_status_types (name)
VALUES
    ('OK'),
    ('WARNING'),
    ('ALARM'),
    ('UNKNOWN'),
    ('PAUSED'),
    ('DELETED')
    ON CONFLICT
	DO NOTHING;

CREATE TABLE IF NOT EXISTS systems (
    id serial PRIMARY KEY,
    uuid UUID NOT NULL,
    name varchar(255),
    system_status_type_id int NOT NULL,
    CONSTRAINT fk_system_status_type
        FOREIGN KEY(system_status_type_id)
            REFERENCES system_status_types(id)
);

CREATE TABLE IF NOT EXISTS system_event_types (
    id serial PRIMARY KEY,
    name varchar(255) UNIQUE
);

INSERT INTO
	  system_event_types (name)
VALUES
    ('INITIALIZED'),
    ('PAUSED'),
    ('HEARTBEAT'),
    ('TEMPERATURE_TOO_HOT'),
    ('TEMPERATURE_TOO_COLD'),
    ('DISK_ALMOST_FULL'),
    ('FAN_MALFUNCTION'),
    ('DISK_FULL'),
    ('SYSTEM_CRASH')
ON CONFLICT
	  DO NOTHING;

CREATE TABLE IF NOT EXISTS system_events (
    id serial PRIMARY KEY,
    uuid UUID NOT NULL,
    system_event_type_id int NOT NULL,
    payload jsonb not null default '{}'::jsonb,
    creation_date TIMESTAMPTZ NOT NULL,
    received_date TIMESTAMPTZ NOT NULL,
    system_id int NOT NULL,
    CONSTRAINT fk_system
        FOREIGN KEY(system_id)
            REFERENCES systems(id),
    CONSTRAINT fk_system_event_type
        FOREIGN KEY(system_event_type_id)
            REFERENCES system_event_types(id)
);

CREATE TABLE IF NOT EXISTS notification_severities (
    id serial PRIMARY KEY,
    name varchar(255) UNIQUE
);

INSERT INTO
	  notification_severities (name)
VALUES
    ('INFO'),
    ('WARNING'),
    ('ALARM')
ON CONFLICT
	  DO NOTHING;

CREATE TABLE IF NOT EXISTS notifications (
    id serial PRIMARY KEY,
    uuid UUID NOT NULL,
    subject varchar(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMPTZ NOT NULL,
    severity_id int NOT NULL,
    system_event_id int NOT NULL,
    CONSTRAINT fk_severity
        FOREIGN KEY(severity_id)
            REFERENCES notification_severities(id),
    CONSTRAINT fk_system_event_id
        FOREIGN KEY(system_event_id)
            REFERENCES system_events(id)
);