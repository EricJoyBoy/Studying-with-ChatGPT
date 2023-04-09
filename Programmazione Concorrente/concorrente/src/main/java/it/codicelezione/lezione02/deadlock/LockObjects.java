package it.codicelezione.lezione02.deadlock;

import java.util.concurrent.ThreadLocalRandom;

public class LockObjects implements Runnable {
    private Object a,b;
    public LockObjects(Object o1, Object o2){
        this.a = o1;
        this.b = o2;

    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(10,100));
            synchronized(a){
                Thread.sleep(ThreadLocalRandom.current().nextInt(10,100));
                    synchronized(b) {
                        System.out.println("Lock worked "+a.toString()+", "+b.toString());
                    }
                }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        

       
        }
        
    }
    
}
