package org.fin.ejb.forex;

import javax.ejb.Remote;

@Remote
public interface IMyForexServiceRemote {

    String doBusinessTask();

}
