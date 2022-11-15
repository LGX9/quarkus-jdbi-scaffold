package de.pfwd.scaffold.quarkusjdbi.filter;

import io.quarkus.security.identity.SecurityIdentity;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import org.jboss.logmanager.MDC;

@Provider
public class LoggingInterceptor implements ContainerRequestFilter {

    @Inject
    SecurityIdentity securityIdentity;

    @Override
    public void filter(ContainerRequestContext context) {
        MDC.put("requestId", UUID.randomUUID().toString());
        String userName = securityIdentity.getPrincipal().getName();

        MDC.put("userName", !userName.isBlank() ? userName : "anonymous");
    }
}
