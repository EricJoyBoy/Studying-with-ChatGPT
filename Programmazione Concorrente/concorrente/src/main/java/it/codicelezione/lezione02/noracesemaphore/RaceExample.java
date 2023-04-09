package it.codicelezione.lezione02.noracesemaphore;

import java.util.concurrent.Semaphore;

public class RaceExample extends Thread {
    public Counter myCounter;
    private Semaphore theSemaphore;

    public RaceExample(Counter c, Semaphore s){
        myCounter = c;
        theSemaphore = s;

    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                theSemaphore.acquire();
            } catch (InterruptedException e) {
            
                e.printStackTrace();
            }
            myCounter.add(1);
                theSemaphore.release();
            
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Semaphore semaphore = new Semaphore(1);
        RaceExample p1 = new RaceExample(counter, semaphore);
        RaceExample p2 = new RaceExample(counter, semaphore);
        p1.start();
        p2.start();
        p1.join();
        p2.join();
        System.out.println("Counter = "+ counter.count);
    }
}
