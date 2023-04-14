package it.codicelezione.lezione03.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Consumatore extends Thread{
    CellaCondivisa cella;
    int v;
    Semaphore full;
    Semaphore empty;

    public Consumatore(String s, CellaCondivisa c, Semaphore full, Semaphore empty){
        super(s);
        this.cella = c;
        this.empty = empty;
        this.full = full;
    }
  
    @Override
    public void run() {
        for(;;){
            try {
                full.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            v = cella.getValore();
            empty.release();
        }        
    }
}
