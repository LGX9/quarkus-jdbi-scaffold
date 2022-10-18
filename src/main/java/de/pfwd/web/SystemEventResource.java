package de.pfwd.web;

import de.pfwd.service.systemevent.SystemEventService;
import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import de.pfwd.web.dto.ResponseDTO.SystemEventResponseDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/system-events")
public class SystemEventResource {

//  @Inject
//  Logger log;

  private static Logger log = LoggerFactory.getLogger(SystemEventResource.class);

  @Inject
  SystemEventService systemEventService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<SystemEventResponseDTO> getSystemEvents() {
    log.info("Retrieving System Events");
    return systemEventService.retrieveSystemEvents();
  }


  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void createSystemEvent(SystemEventRequestDTO event) {
    log.info("Creating System Event " + event.eventType());
    systemEventService.createSystemEvent(event);
  }

}
