package org.fin.ejb.forex;

import org.fin.dto.Currency;
import org.jboss.ejb3.annotation.Clustered;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Clustered
@Stateless
public class MyForexServiceBean implements IMyForexServiceRemote, IMyForexServiceLocal {
    @Override
    public String doBusinessTask() {
        return "business ok";
    }

    @Override
    @TransactionTimeout(value = 300)
    public String doWork() {
        return "work done";
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Currency> currencies() {
        List<Currency> res = new ArrayList<>();
        res.add(new Currency("CHF", "756", "Swiss franc", "Switzerland"));
        res.add(new Currency("EUR", "978", "Euro", "France"));
        res.add(new Currency("USD", "840)", "United States dollar", "United States"));
        res.add(new Currency("BRL", "986", "Brazilian real", "Brazil"));
        res.add(new Currency("JPY", "392", "Japanese yen", "Japan"));
        return res;
    }
}
