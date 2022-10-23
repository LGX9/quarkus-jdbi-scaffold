package de.pfwd.scaffold.quarkusjdbi.persist;

import de.pfwd.scaffold.quarkusjdbi.persist.repositories.NotificationRepository;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemEventRepository;
import de.pfwd.scaffold.quarkusjdbi.persist.repositories.SystemRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import org.jdbi.v3.core.Jdbi;

@Dependent
public class RepositoryProvider {

    @Inject Jdbi jdbi;

    @Produces
    @ApplicationScoped
    public SystemRepository systemRepository() {
        return jdbi.onDemand(SystemRepository.class);
    }

    @Produces
    @ApplicationScoped
    public SystemEventRepository systemEventRepository() {
        return jdbi.onDemand(SystemEventRepository.class);
    }

    @Produces
    @ApplicationScoped
    public NotificationRepository notificationRepository() {
        return jdbi.onDemand(NotificationRepository.class);
    }
}
