package org.fin.ejb.forex;

import org.fin.dto.Currency;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IMyForexServiceLocal {

    String doWork();

    List<Currency> currencies();

}
