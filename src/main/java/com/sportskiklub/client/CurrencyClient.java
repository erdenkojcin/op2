package com.sportskiklub.client;

import com.sportskiklub.model.CurrencyResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "currency-api")
public interface CurrencyClient {
    @GET
    @Path("/api/rates")
    CurrencyResponse getRate(@QueryParam("from") String from, @QueryParam("to") String to);
}
