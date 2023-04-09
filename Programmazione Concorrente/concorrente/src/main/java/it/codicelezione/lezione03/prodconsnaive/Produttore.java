package it.codicelezione.lezione03.prodconsnaive;

import java.util.concurrent.ThreadLocalRandom;

public class Produttore extends Thread {
    CellaCondivisa cella;

    public Produttore(CellaCondivisa c){
        this.cella = c;

    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(10,100));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized(cella){
                int v = (int)(100*Math.random());
                cella.setValore(v);
                System.out.println("Produttore " + i +" " + v + " ");
            }

        }
    }

}
