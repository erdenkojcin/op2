package com.sportskiklub.resource;

import com.sportskiklub.client.CurrencyClient;
import com.sportskiklub.model.CurrencyResponse;
import com.sportskiklub.model.Igrac;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/currencyConversion")
public class CurrencyResource {

    @Inject
    @RestClient
    CurrencyClient currencyClient;

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @RolesAllowed("admin")
    @Transactional
    public Response convert(@QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("value") double value, @QueryParam("userId") Long userId) {
        Igrac igrac = em.find(Igrac.class, userId);
        if (igrac == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User sa id-jem " + userId + " nije pronadjen").build();
        }

        CurrencyResponse currencyResponse = currencyClient.getRate(from, to);
        double convertedValue = value * currencyResponse.getRate();

        currencyResponse.setValue(value);
        currencyResponse.setConvertedValue(convertedValue);
        currencyResponse.setIgrac(igrac);

        em.persist(currencyResponse);

        return Response.ok().entity(currencyResponse).build();
    }
}
