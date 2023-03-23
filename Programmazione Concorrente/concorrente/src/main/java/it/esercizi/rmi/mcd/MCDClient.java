package it.esercizi.rmi.mcd;

import java.rmi.Naming;

public class MCDClient {
    public static void main(String args[]) {
        try {
          MCDInterface server = (MCDInterface) Naming.lookup("rmi://localhost/MCDServer");
          int a = 90;
          int b = 8;
          int mcd = server.calcolaMCD(a, b);
          System.out.println("MCD di " + a + " e " + b + " = " + mcd);
        } catch (Exception e) {
          System.out.println("MCDClient fallito: " + e);
        }
      }    
}
