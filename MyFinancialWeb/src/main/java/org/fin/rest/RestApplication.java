package org.fin.rest;

import org.fin.ejb.forex.MyForexServiceBean;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    private Set<Object> services = new HashSet<>();

    public RestApplication() {
        services.add(new FinancialAPI(new MyForexServiceBean()));
    }

    @Override
    public Set<Object> getSingletons() {
        return new HashSet<>(services);
    }
}
