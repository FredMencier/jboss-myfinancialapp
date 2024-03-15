package org.fin.rest;

import org.fin.dto.Currency;
import org.fin.ejb.forex.IMyForexServiceLocal;
import org.fin.ejb.forex.MyForexServiceBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/currency")
public class FinancialAPI {

    MyForexServiceBean myForexService;

    public FinancialAPI(MyForexServiceBean myForexServiceBean)  {
        myForexService = myForexServiceBean;
    }

    @GET
    @Path("/currencies")
    @Produces({"application/json"})
    public List<Currency> getCurrencies() {
        return myForexService.currencies();
    }
}
