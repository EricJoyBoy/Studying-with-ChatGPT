package it.codicelezione.lezione12.helloperson.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.codicelezione.lezione12.helloperson.server.HelloPerson;
import it.codicelezione.lezione12.helloperson.server.Person;

public class HelloClient {
    public static void main(String[] args) {
        try {
          Registry registro = LocateRegistry.getRegistry(1099);
          HelloPerson stub = (HelloPerson) registro.lookup("HelloPerson");
          String response = stub.sayHello();
          System.out.println("response: " + response);
          Person someone = new Person("Emerenziano Paronzini");
          response = stub.sayHello(someone);
          System.out.println("response: " + response);
        } catch (Exception e) {
          System.err.println("Client exception: " + e.toString());
          e.printStackTrace();
        }
      }  
}

