package org.fin.ejb.deposit;

public interface IMyDepositServiceLocal {

    Double calculateInterest();

    void cleanCalculation();
}
