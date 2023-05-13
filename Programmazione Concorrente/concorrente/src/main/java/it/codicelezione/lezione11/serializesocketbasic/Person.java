package it.codicelezione.lezione11.serializesocketbasic;

import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1;
	String name;
	Person(String n) {
		this.name = n;
	}
    
}
