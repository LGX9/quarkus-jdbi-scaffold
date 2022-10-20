package de.pfwd.scaffold.quarkusjdbi.web;

import de.pfwd.scaffold.quarkusjdbi.service.systemevent.SystemEventService;
import de.pfwd.scaffold.quarkusjdbi.web.dto.RequestDTO;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO;
import io.quarkus.logging.Log;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/system-events")
public class SystemEventResource {

    @Inject SystemEventService systemEventService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200)
    public List<ResponseDTO.SystemEventResponseDTO> getSystemEvents() {
        Log.info("Retrieving System Events");
        return systemEventService.retrieveSystemEvents();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    public void createSystemEvent(RequestDTO.SystemEventRequestDTO event) {
        Log.info("Creating System Event " + event.eventType());
        systemEventService.createSystemEvent(event);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(204)
    @Path("/{uuid}")
    public void deleteByUUID(@PathParam("uuid") UUID uuid) {
        systemEventService.deleteSystemEventByUUID(uuid);
    }
}
