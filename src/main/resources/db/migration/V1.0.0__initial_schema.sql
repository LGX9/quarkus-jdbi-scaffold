CREATE TABLE IF NOT EXISTS system_events (
    id serial PRIMARY KEY,
    event_type varchar(255) NOT NULL,
    payload jsonb not null default '{}'::jsonb,
    creation_date TIMESTAMPTZ NOT NULL,
    received_date TIMESTAMPTZ NOT NULL
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
    subject varchar(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMPTZ NOT NULL,
    severity_id int NOT NULL,
    CONSTRAINT fk_severity
        FOREIGN KEY(severity_id)
            REFERENCES notification_severities(id)
);