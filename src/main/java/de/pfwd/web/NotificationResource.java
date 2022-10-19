package de.pfwd.web;

import de.pfwd.service.notification.NotificationService;
import de.pfwd.web.dto.ResponseDTO.NotificationResponseDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/notifications")
public class NotificationResource {

    @Inject NotificationService notificationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NotificationResponseDTO> getNotifications() {
        return notificationService.retrieveNotifications();
    }
}
