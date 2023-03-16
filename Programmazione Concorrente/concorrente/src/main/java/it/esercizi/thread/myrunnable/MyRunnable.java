package it.esercizi.thread.myrunnable;

public class MyRunnable implements Runnable {

    public void run() {
        // scrive tre volte sullo standard output
        for (int i = 0; i < 3; i++) {
            System.out.println("thread");
        }
    }
    
    public static void main(String[] args) {
        // crea un'istanza di Runnable
        Runnable runnable = new MyRunnable();

        // crea un nuovo thread e passa l'istanza di runnable al costruttore
        Thread thread = new Thread(runnable);

        // avvia il thread
        thread.start();

        // scrive tre volte sullo standard output
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
        }
    }

}
