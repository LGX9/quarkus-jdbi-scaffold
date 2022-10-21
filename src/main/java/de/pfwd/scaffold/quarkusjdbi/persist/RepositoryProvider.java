package de.pfwd.scaffold.quarkusjdbi.persist;

import de.pfwd.scaffold.quarkusjdbi.persist.repositories.NotificationRepository;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemEventRepository;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

@Singleton
public class RepositoryProvider {

    @Inject Jdbi jdbi;

    @Singleton
    public SystemRepository systemRepository() {
        return jdbi.onDemand(SystemRepository.class);
    }

    @Singleton
    public SystemEventRepository systemEventRepository() {
        return jdbi.onDemand(SystemEventRepository.class);
    }

    @Singleton
    public NotificationRepository notificationRepository() {
        return jdbi.onDemand(NotificationRepository.class);
    }
}
