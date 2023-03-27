package it.codicelezione.lezione01.waitalive;

public class AliveTestExit {
    
    public static void main(String[] args) throws InterruptedException {
        System.err.println("I thread stanno per partire");
        Thread t1 = new ExampleWithSleeps("t1");
        t1.start();
        Thread t2 = new ExampleWithSleeps("t2");
        t2.start();
        Thread t3 = new ExampleWithSleeps("t3");
        t3.start();
        while(t1.isAlive() || t2.isAlive() || t3.isAlive()){
            Thread.sleep(300);
    }
    
    System.err.println("Chiude l'applicazione");
    System.exit(0);
    
    }
    
}
