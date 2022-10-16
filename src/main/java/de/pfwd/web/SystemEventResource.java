package de.pfwd.web;

import de.pfwd.service.SystemEventService;
import de.pfwd.web.dto.RequestDTO.SystemEventRequestDTO;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/system-events")
public class SystemEventResource {

  @Inject
  SystemEventService systemEventService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void createSystemEvent(SystemEventRequestDTO event) {
    systemEventService.createSystemEvent(event);
  }

}
