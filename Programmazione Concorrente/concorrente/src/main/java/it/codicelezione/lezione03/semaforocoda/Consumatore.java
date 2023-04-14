package it.codicelezione.lezione03.semaforocoda;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Consumatore extends Thread {
    Coda buffer;
    int v;
	Semaphore full;
	Semaphore empty;

    public Consumatore(String s, Coda c, Semaphore full, Semaphore empty){
		super(s);
		this.buffer=c;
		this.empty=empty;
		this.full=full;
	}
    public void run(){
		for(;;){
			try{
				full.acquire();
			} catch(InterruptedException e) {}
			v=buffer.getItem();
			empty.release();
			try {
				Thread.sleep(ThreadLocalRandom.current().
						nextInt(10, 100));
			} catch (InterruptedException e) {  }

		}
	}


}
