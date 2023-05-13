package it.codicelezione.lezione13.currencyconverter.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.codicelezione.lezione13.currencyconverter.server.CurrencyConverter;

public class CurrencyConverterClient {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
          try {
            Registry registry = LocateRegistry.getRegistry(host);
            CurrencyConverter stub = (CurrencyConverter)registry.lookup("CurrencyConverter");
            System.out.println(stub);
            for(int usd = 1; usd < 10; usd++){
              System.out.println(usd + " USD = " + stub.toEur(usd) + " EUR");
            }
            for(int eur = 1; eur < 10; eur++){
              System.out.println(eur + " EUR = " + stub.toUsd(eur) + " USD");
            }    
          } catch (Exception e) {
              System.err.println("Client exc.: " + e.toString());
              e.printStackTrace();
          }
      }
}
