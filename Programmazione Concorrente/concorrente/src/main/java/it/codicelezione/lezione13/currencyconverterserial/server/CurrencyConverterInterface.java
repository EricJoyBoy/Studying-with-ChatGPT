package it.codicelezione.lezione13.currencyconverterserial.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CurrencyConverterInterface extends Remote  {
    Conversion compute(Conversion conv) throws RemoteException;
    
}
