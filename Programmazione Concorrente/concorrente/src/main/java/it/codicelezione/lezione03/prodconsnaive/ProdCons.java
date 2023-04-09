package it.codicelezione.lezione03.prodconsnaive;

import it.codicelezione.lezione01.threadcreation.ThreadExample;

public class ProdCons {
    public static void main(String[] args) {
        CellaCondivisa cella =  new CellaCondivisa();
        Consumatore cons  = new Consumatore(cella);
        Produttore prod = new Produttore(cella);
        cons.start();
        prod.start();
    }
    
}
