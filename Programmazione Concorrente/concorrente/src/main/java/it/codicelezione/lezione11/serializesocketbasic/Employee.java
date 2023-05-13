package it.codicelezione.lezione11.serializesocketbasic;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private static final long serialVersionUID = 1;
    int serNum;
    float salary; 
    

    Employee(String name, int no, float sal){
        super(name);
        serNum = no;
        salary = sal;
    }

    void display(){
        System.out.println(name+"   "+serNum+"    "+salary);
    }
}
