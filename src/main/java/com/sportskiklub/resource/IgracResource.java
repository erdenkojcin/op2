package com.sportskiklub.resource;

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
    public String addIgrac(Igrac igrac) {
        igracService.sacuvajIgraca(igrac);
        return "Igrac dodat!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllIgraci")
    public Response getAllIgraci() {
        List<Igrac> igraci = igracService.sviIgraci();
        return Response.ok().entity(igraci).build();
    }
}