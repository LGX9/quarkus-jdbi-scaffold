package de.pfwd.db;

import de.pfwd.db.repositories.NotificationRepository;
import de.pfwd.db.repositories.SystemEventRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

@Singleton
public class JdbiConfiguration {

  @Inject
  Jdbi jdbi;

  @Singleton
  public NotificationRepository notificationRepository() {
    return jdbi.onDemand(NotificationRepository.class);
  }

  @Singleton
  public SystemEventRepository systemEventRepository() {
    return jdbi.onDemand(SystemEventRepository.class);
  }

}
