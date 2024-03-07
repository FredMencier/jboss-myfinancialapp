package org.fin.ejb.forex;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IMyForexServiceLocal {

    String doWork();

    List<String> loadSomeData();

}
