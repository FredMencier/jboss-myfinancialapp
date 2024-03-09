package org.fin.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class FinancialAPI {

    @GET
    @Path("/getAvailableCurrencies")
    public String getAvailableCurrencies() {
        return "CHF;EUR;USD";
    }

}
