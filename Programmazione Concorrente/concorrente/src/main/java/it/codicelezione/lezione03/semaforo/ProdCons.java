package it.codicelezione.lezione03.semaforo;

import java.util.concurrent.Semaphore;

public class ProdCons {
    final int BUFFERSIZE = 4;
    final Semaphore full = new Semaphore(0);
    final Semaphore empty = new Semaphore(BUFFERSIZE);

    void exec(){
		CellaCondivisa cella=new CellaCondivisa(4);
		new Produttore("Prod", cella, full, empty).start();
		new Consumatore("Cons", cella, full, empty).start();
	}
    public static void main(String[] args) {
        new ProdCons().exec();
    }
}
