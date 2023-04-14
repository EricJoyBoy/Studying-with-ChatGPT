package it.codicelezione.lezione03.prodconsnaivethreadsafe;

public class ProdCons {
    public static void main(String[] args) {
        CellaCondivisa cella=new CellaCondivisa();
		Thread tp=new Produttore(cella);
		Thread tc=new Consumatore(cella);
		tp.start();
		tc.start();
    }
}
