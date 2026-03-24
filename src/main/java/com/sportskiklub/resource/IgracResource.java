package com.sportskiklub.resource;

import com.sportskiklub.exception.IgracException;
import com.sportskiklub.model.Igrac;
import com.sportskiklub.service.IgracService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/igrac")
public class IgracResource {

    @Inject
    private IgracService igracService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addIgrac")

    public Response addIgrac(Igrac igrac) {
        try {
            igracService.createIgrac(igrac);
        } catch (IgracException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllIgraci")

    public Response getAllIgraci() {
        List<Igrac> igraci = null;
        try {
            igraci = igracService.gettAllIgraci();
        } catch (IgracException e) {
            Response.status(Response.Status.NO_CONTENT).entity(e.getMessage()).build();
        }
        return Response.ok().entity(igraci).build();
    }
}