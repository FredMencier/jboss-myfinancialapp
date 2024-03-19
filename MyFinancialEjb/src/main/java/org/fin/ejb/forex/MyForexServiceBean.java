package org.fin.ejb.forex;

import org.fin.dto.Currency;
import org.jboss.ejb3.annotation.Clustered;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;
import org.fin.da.FinancialDA;

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
        return FinancialDA.getInstance().findCurrencies();
    }
}
