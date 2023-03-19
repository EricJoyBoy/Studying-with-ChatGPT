package it.esercizi.threadsafe.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CodaBloccante {
    
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(1); // Coda condivisa con dimensione massima 1
        
        Thread prod = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.put(i); // Produzione
                    System.out.println("Prodotto: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread cons = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Integer val = buffer.poll(1, TimeUnit.SECONDS); // Consumo con timeout di 1 secondo
                    if (val != null) {
                        System.out.println("Consumato: " + val);
                    } else {
                        System.out.println("Timeout di attesa scaduto");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        prod.start();
        cons.start();
    }
}
