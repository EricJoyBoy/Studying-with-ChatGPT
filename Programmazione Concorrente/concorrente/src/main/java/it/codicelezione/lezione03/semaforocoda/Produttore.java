package it.codicelezione.lezione03.semaforocoda;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Produttore extends Thread {
    Coda buffer;
    int v;
    Semaphore full;
    Semaphore empty;
    
    public Produttore(String s, Coda c, Semaphore full, Semaphore empty){
		super(s);
		this.buffer=c;
		this.empty=empty;
		this.full=full;
    }

    public void run(){
		int i=0;
		for(;;){
			try {
				Thread.sleep(ThreadLocalRandom.current().
						nextInt(10, 100));
			} catch (InterruptedException e) {  }

			try{
				empty.acquire();
			} catch(InterruptedException e) {}
			buffer.setItem(i++);
			full.release();
		}
	}
}
