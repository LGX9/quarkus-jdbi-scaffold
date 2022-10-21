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
        Log.debugv("Retrieving Events for systems");
        return systemEventService.retrieveSystemEvents();
    }

    @GET
    @Path("/{systemUUID}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200)
    public List<ResponseDTO.SystemEventResponseDTO> getSystemEventsFromSystem(
            @PathParam("systemUUID") UUID systemUUID) {
        Log.debugv("Retrieving Events for system: {}", systemUUID);
        return systemEventService.retrieveSystemEventsFromSystem(systemUUID);
    }

    @POST
    @Path("/{systemUUID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    public void createSystemEvent(
            @PathParam("systemUUID") UUID systemUUID, RequestDTO.SystemEventRequestDTO event) {
        Log.debugv("Creating System Event: {}", event.eventType());
        systemEventService.createSystemEvent(event, systemUUID);
    }

    @DELETE
    @Path("/{systemUUID}/{eventUUID}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(204)
    public void deleteByUUID(
            @PathParam("systemUUID") UUID systemUUID, @PathParam("eventUUID") UUID eventUUID) {
        Log.debugv("Deleting Event {} of System {}", eventUUID, systemUUID);
        systemEventService.deleteSystemEventByUUID(eventUUID);
    }
}
