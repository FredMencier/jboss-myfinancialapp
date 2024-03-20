package org.fin.ejb.forex;

import org.fin.da.FinancialDA;
import org.fin.dto.Currency;
import org.fin.entity.CurrencyEntity;
import org.jboss.ejb3.annotation.Clustered;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Clustered
@Stateless
public class MyForexServiceBean implements IMyForexServiceRemote, IMyForexServiceLocal {

    @PersistenceContext(unitName = "FinancialPU")
    private EntityManager entityManager;

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
        FinancialDA financialDA = new FinancialDA(entityManager);
        return financialDA.findCurrencies();
    }
}
