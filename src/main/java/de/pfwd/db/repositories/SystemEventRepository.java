package de.pfwd.db.repositories;

import de.pfwd.service.SystemEvent;
import java.time.OffsetDateTime;
import java.util.Map;
import org.jdbi.v3.postgres.HStore;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SystemEventRepository {

  @SqlUpdate("""
      INSERT INTO system_events
        (event_type, creation_date, received_date)
      VALUES
        (:eventType, :creationDate, :receivedDate)
  """)
  void createSystemEvent(@Bind("eventType") SystemEvent eventType, Map<String, String> payload,
      @Bind("creationDate")OffsetDateTime creationDate, @Bind("receivedDate")OffsetDateTime receivedDate);


}
