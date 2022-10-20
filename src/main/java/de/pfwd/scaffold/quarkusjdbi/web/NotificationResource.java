package de.pfwd.scaffold.quarkusjdbi.web;

import de.pfwd.scaffold.quarkusjdbi.service.notification.NotificationService;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO.NotificationResponseDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("/notifications")
public class NotificationResource {

    @Inject NotificationService notificationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200)
    public List<NotificationResponseDTO> getNotifications() {
        return notificationService.retrieveNotifications();
    }
}
