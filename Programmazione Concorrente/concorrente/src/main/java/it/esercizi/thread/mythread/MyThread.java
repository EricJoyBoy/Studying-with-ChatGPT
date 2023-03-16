package it.esercizi.thread.mythread;

public class MyThread extends Thread{

    @Override
    public  void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("thread");
        }
    }
    

    public static void main(String[] args) {
        // Creazione e avvio del thread
        MyThread t = new MyThread();
        t.start();

        // Scrittura di "main" tre volte sullo standard output
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
        }
    }

}
