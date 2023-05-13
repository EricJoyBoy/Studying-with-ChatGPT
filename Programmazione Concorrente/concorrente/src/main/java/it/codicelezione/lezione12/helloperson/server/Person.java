package it.codicelezione.lezione12.helloperson.server;

import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    public Person(String n){
       this.name = n;
    }
    public String getName(){
       return this.name;
    }
  
  
  
}
