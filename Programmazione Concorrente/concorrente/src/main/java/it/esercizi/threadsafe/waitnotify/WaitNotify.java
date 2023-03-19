package it.esercizi.threadsafe.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotify {
    
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>(); // Coda condivisa

        Thread prod = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.size() == 1) { // Attende se la coda è piena
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.add(i); // Produzione
                    System.out.println("Prodotto: " + i);
                    buffer.notify(); // Sveglia il consumatore
                }
            }
        });

        Thread cons = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.size() == 0) { // Attende se la coda è vuota
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int val = buffer.poll(); // Consumo
                    System.out.println("Consumato: " + val);
                    buffer.notify(); // Sveglia il produttore
                }
            }
        });

        prod.start();
        cons.start();
    }
}
