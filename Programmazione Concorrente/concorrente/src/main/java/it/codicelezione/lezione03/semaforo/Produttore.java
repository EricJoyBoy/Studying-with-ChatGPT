package it.codicelezione.lezione03.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Produttore extends Thread {
    CellaCondivisa cella;
	Semaphore full;
	Semaphore empty;
	

	public Produttore(String s, CellaCondivisa c, Semaphore full, Semaphore empty){
		super(s);
		this.cella=c;
		this.empty=empty;
		this.full=full;
	}


	@Override
	public void run() {
		int i = 0;
		for (;;) {
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(10,200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				empty.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cella.setValore(i++);
			full.release();
		}
	}
   
}


/*
 * 
 * 
 * Questo codice Java definisce la classe "Consumatore" che estende la classe Thread. Questa classe rappresenta un thread che consuma i valori da una cella condivisa di tipo "CellaCondivisa". La classe utilizza due oggetti di tipo "Semaphore" per sincronizzare il produttore e il consumatore.

Nel costruttore della classe, vengono passati quattro parametri: il nome del thread, l'oggetto della cella condivisa, e due oggetti Semaphore che rappresentano il numero di spazi pieni e vuoti rispettivamente.

Il metodo "run()" della classe contiene un loop infinito che tenta di acquisire il semaforo "full" tramite il metodo "acquire()". Questo metodo blocca il thread fino a quando non c'è almeno un valore disponibile nella cella condivisa. Una volta che il semaforo "full" è stato acquisito, il valore viene letto dalla cella condivisa tramite il metodo "getValore()" e successivamente viene rilasciato il semaforo "empty" tramite il metodo "release()". Questo permette al produttore di inserire un nuovo valore nella cella condivisa.

In sostanza, la classe "Consumatore" rappresenta un thread che consume un valore dalla cella condivisa e rilascia un semaforo per indicare che la cella è vuota e può essere riempita dal produttore. Questo è un esempio di un modello di sincronizzazione a semafori utilizzato per gestire l'accesso concorrente a risorse condivise.
 */
