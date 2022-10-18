package de.pfwd.filter;

import java.util.UUID;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import org.slf4j.MDC;
//import org.apache.logging.log4j.ThreadContext;


@Provider
public class LoggingInterceptor implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext context) {
//    ThreadContext.put("uniqueID", UUID.randomUUID().toString());
    MDC.put("requestId", UUID.randomUUID().toString());
  }
}

