package de.pfwd.filter;

import java.util.UUID;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import org.jboss.logmanager.MDC;

@Provider
public class LoggingInterceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext context) {
        MDC.put("requestId", UUID.randomUUID().toString());
    }
}
