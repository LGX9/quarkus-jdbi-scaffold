package de.pfwd.scaffold.quarkusjdbi.testresource;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Collections;
import java.util.Map;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresResource implements QuarkusTestResourceLifecycleManager {

    private GenericContainer<?> postgres;

    @Override
    public Map<String, String> start() {
        postgres =
                new PostgreSQLContainer("postgres:15.0")
                        .withDatabaseName("integration-tests-db")
                        .withUsername("TestUser")
                        .withPassword("TestPassword")
                        .withExposedPorts(5432);
        postgres.setPortBindings(Collections.singletonList("5432:5432"));

        postgres.start();

        Log.info(postgres.getContainerInfo());

        return Collections.singletonMap("containerInfo", postgres.getContainerInfo().toString());
    }

    @Override
    public void stop() {}
}
