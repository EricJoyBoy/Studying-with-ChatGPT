package it.codicelezione.lezione01.preemptivetest;

public class PreemptiveTest {
    public static void main(String[] args) {
        System.out.println("Main : inizio");
        Thread t1 = new  BusyThread();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t2 = new MyThread();
        t2.setName("Ciao");
        t2.start();
    }
    
}
