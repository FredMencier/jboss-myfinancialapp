package org.fin.rest;

import org.fin.dto.Currency;
import org.fin.ejb.forex.IMyForexServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/currency")
public class FinancialAPI {

    @EJB
    IMyForexServiceLocal myForexService;

    /**
     * Donne les liste des monnaies disponibles
     * @return
     */
    @GET
    @Path("/currencies")
    @Produces({"application/json"})
    public List<Currency> getCurrencies() {
        return myForexService.currencies();
    }
}
