package it.codicelezione.lezione12.hello.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello  extends Remote {
    String sayHello() throws RemoteException;
}
