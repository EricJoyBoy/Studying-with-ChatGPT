
package it.esercizi.rmi.mcd;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MCDServer extends UnicastRemoteObject implements MCDInterface {

    public MCDServer() throws RemoteException {}
  
    public int calcolaMCD(int a, int b) throws RemoteException {
      if (b == 0) {
        return a;
      } else {
        return calcolaMCD(b, a % b);
      }
    }
  
    public static void main(String args[]) {
      try {
        MCDServer server = new MCDServer();
        Naming.rebind("MCDServer", server);
        System.out.println("MCDServer pronto.");
      } catch (Exception e) {
        System.out.println("MCDServer fallito: " + e);
        e.printStackTrace();
      }
    }
  }











