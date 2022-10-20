package de.pfwd.scaffold.quarkusjdbi.config;

import io.agroal.api.AgroalDataSource;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

@Singleton
public class JdbiConfiguration {

    @Inject AgroalDataSource defaultDataSource;

    @Singleton
    public Jdbi createJdbi() {
        return Jdbi.create(defaultDataSource)
                .installPlugin(new SqlObjectPlugin())
                .installPlugin(new PostgresPlugin());
    }
}
