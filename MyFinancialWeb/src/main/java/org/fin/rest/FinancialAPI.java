package org.fin.rest;

import org.fin.ejb.forex.IMyForexServiceLocal;
import org.fin.ejb.forex.MyForexServiceBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/")
public class FinancialAPI {

    @GET
    @Path("/getAvailableCurrencies")
    public List<String> getAvailableCurrencies() {
        IMyForexServiceLocal myForexService = new MyForexServiceBean();
        return myForexService.loadSomeData();
    }

}
