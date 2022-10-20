package de.pfwd.scaffold.quarkusjdbi.persist;

import de.pfwd.scaffold.quarkusjdbi.persist.repositories.NotificationRepository;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemEventRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

@Singleton
public class Repositories {

    @Inject Jdbi jdbi;

    @Singleton
    public NotificationRepository notificationRepository() {
        return jdbi.onDemand(NotificationRepository.class);
    }

    @Singleton
    public SystemEventRepository systemEventRepository() {
        return jdbi.onDemand(SystemEventRepository.class);
    }
}
