package de.pfwd.db;

import io.agroal.api.AgroalDataSource;
import java.sql.Connection;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

@Singleton
public class DatabaseConnector {

  @Inject
  AgroalDataSource defaultDataSource;

  public Connection createConnection() throws Exception {
      return defaultDataSource.getConnection();
  }

  @Singleton
  public Jdbi getJdbi() {
    return Jdbi.create(defaultDataSource)
        .installPlugin(new SqlObjectPlugin())
        .installPlugin(new PostgresPlugin());

  }
}
