package it.codicelezione.lezione01.killwithinterrupt;

public class JoinWaitExit {

    public static void main(String[] args) throws InterruptedException {
        System.err.println("I thread stanno per partire");
        Thread t1 = new ExampleWithSleeps("t1"); t1.start();
        Thread t2 = new ExampleWithSleeps("t1"); t2.start();
        Thread t3 = new ExampleWithSleeps("t1"); t3.start();
        System.err.println("I thread sono partiti");
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t1.join();
        t2.join();
        t3.join();

        System.err.println("chiudiamo l'applicazione");
        System.exit(0);
    }
    
}
