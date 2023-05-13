package it.codicelezione.lezione11.serializepersonok;

import java.io.Serializable;

public class Employee extends Person implements Serializable{
    private static final long serialVersionUID = 1;
	int serialNumber;
	float salary;   
	Employee(String name, int no, float sal){
		super(name);
		serialNumber = no;
		salary = sal;
	}
	void display(){
		System.out.println(name+"   "+serialNumber+"    "+salary);
	}
}
