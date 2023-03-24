package it.codicelezione.lezione01.preemptivetest;

public class MyThread extends Thread{

    @Override
    public void run() {
        String str = Thread.currentThread().getName();
        while (true) {
            System.out.println(str);
        }
    }
    
}
