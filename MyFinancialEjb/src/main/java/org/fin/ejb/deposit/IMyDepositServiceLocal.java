package org.fin.ejb.deposit;

import javax.ejb.Local;

@Local
public interface IMyDepositServiceLocal {

    Double calculateInterest();

    void cleanCalculation();
}
