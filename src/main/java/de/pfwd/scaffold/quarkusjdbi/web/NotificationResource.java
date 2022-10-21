package de.pfwd.scaffold.quarkusjdbi.web;

import de.pfwd.scaffold.quarkusjdbi.service.notification.NotificationService;
import de.pfwd.scaffold.quarkusjdbi.web.dto.ResponseDTO.NotificationResponseDTO;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    @GET
    @Path("/{systemUUID}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200)
    public List<NotificationResponseDTO> getNotificationsFromSystem(
            @PathParam("systemUUID") UUID systemUUID) {
        return notificationService.retrieveNotificationsFromSystem(systemUUID);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(204)
    @Path("/{uuid}")
    public void deleteByUUID(@PathParam("uuid") UUID uuid) {
        notificationService.deleteNotificationByUUID(uuid);
    }
}
