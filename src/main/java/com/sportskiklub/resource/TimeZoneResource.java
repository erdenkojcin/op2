package com.sportskiklub.resource;

import com.sportskiklub.client.IpClient;
import com.sportskiklub.client.TimeZoneClient;
import com.sportskiklub.exception.TimeZoneException;
import com.sportskiklub.model.Igrac;
import com.sportskiklub.model.TimeResponse;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/timezone")
public class TimeZoneResource {

    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeZoneClient timeZoneClient;

    @Inject
    EntityManager em;

    @GET
    @Path("/current")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrentTimeZone() {
        // prvo uzimamo ip adresu
        String ip = ipClient.getPublicIp();
        System.out.println("ip adresa je: " + ip);
        // pa sa tom ip uzimamo vremensku zonu
        TimeResponse timeResponse = timeZoneClient.getTimeByIp(ip);
        System.out.println(timeResponse);
        return Response.ok().entity(timeResponse).build();
    }

    @GET
    @Path("/getTimezoneByIP")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getTimezoneByIP(@QueryParam("igracId") Long igracId) {
        try {
            Igrac igrac = em.find(Igrac.class, igracId);
            if (igrac == null) {
                throw new TimeZoneException("Igrac sa id-jem " + igracId + " nije pronadjen");
            }
            // uzimamo ip
            String ip = ipClient.getPublicIp();
            System.out.println("ip: " + ip);
            // uzimamo vremensku zonu
            TimeResponse timeResponse = timeZoneClient.getTimeByIp(ip);
            // povezujemo sa igracem
            timeResponse.setIgrac(igrac);
            em.persist(timeResponse);
            // updateujemo igraca sa vremenskom zonom
            igrac.setTimeZone(timeResponse.getTimeZone());
            em.merge(igrac);
            System.out.println(timeResponse);
            return Response.ok().entity(timeResponse).build();
        } catch (TimeZoneException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}