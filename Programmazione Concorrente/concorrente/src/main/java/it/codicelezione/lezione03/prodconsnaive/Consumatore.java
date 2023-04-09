package it.codicelezione.lezione03.prodconsnaive;

import java.util.concurrent.ThreadLocalRandom;

public class Consumatore extends Thread{
    CellaCondivisa cella ;
    public Consumatore(CellaCondivisa c){
        this.cella = c;

    }

    @Override
    public void run() {
        int v;
        for (int i = 0; i <= 10 ; i++) {
            synchronized(cella){
                v = cella.getValore();
                System.out.println("Consumatore" + i +" "+ v + " " );
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(10,200));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
