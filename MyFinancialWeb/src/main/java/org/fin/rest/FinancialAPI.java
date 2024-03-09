package org.fin.rest;

import org.fin.ejb.forex.IMyForexServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/")
public class FinancialAPI {

    @EJB
    IMyForexServiceLocal mForexServiceLocal;

    @GET
    @Path("/getAvailableCurrencies")
    public List<String> getAvailableCurrencies() {
        return mForexServiceLocal.loadSomeData();
    }

}
