package org.fin.ejb.deposit;

import org.fin.ejb.forex.IMyForexServiceLocal;
import org.jboss.ejb3.annotation.Clustered;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.Calendar;

@Clustered
@Stateless
public class MyDepositServiceBean implements IMyDepositServiceLocal {

    @EJB
    IMyForexServiceLocal myServiceLocal;

    @Override
    public Double calculateInterest() {
        Double d = new Double(1.0);
        myServiceLocal.currencies();
        return d * 0.95D;
    }

    @Override
    @TransactionTimeout(value = 1200)
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void cleanCalculation() {
        System.out.println(String.format("do clean calculation at %s", Calendar.getInstance().getTime()));
    }
}
