package de.pfwd.scaffold.quarkusjdbi.web;

import de.pfwd.scaffold.quarkusjdbi.service.system.SystemService;
import de.pfwd.scaffold.quarkusjdbi.web.dto.RequestDTO;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO;
import io.quarkus.logging.Log;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/systems")
public class SystemResource {

    @Inject SystemService systemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200)
    public List<ResponseDTO.SystemResponseDTO> getSystems() {
        Log.debugv("Retrieving Systems: {}");
        return systemService.retrieveSystems();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    public void createSystem(RequestDTO.SystemCreateRequestDTO system) {
        Log.debugv("Creating System with name: {}", system.name());
        systemService.createSystem(system);
    }
}
