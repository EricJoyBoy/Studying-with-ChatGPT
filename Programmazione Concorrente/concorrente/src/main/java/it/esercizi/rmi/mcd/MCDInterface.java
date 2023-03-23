package it.esercizi.rmi.mcd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MCDInterface extends Remote {
    public int calcolaMCD(int a, int b) throws RemoteException;
  }
