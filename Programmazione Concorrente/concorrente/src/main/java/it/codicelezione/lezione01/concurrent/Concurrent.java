package it.codicelezione.lezione01.concurrent;

public class Concurrent extends Thread 
{

    private int myNum;
    
    public Concurrent(int n){
        myNum = n;
    }

    public void run(){
        try {
            Thread.sleep((int) (Math.random()*100));
            System.out.println("In corso , Numero casuale "+ myNum);
            Thread.sleep((int) Math.random()*100);
            System.out.println("In corso, Altro Numero casuale "+myNum);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
public static void main(String[] args) {
    Concurrent a = new Concurrent(1);
    Concurrent b = new Concurrent(2);
    a.start();
    b.start();
    //==> Thread del main
    try {
        Thread.sleep((int) Math.random()*100);
        System.out.println("Thread del main");
        Thread.sleep((int) Math.random()*100);
        System.out.println("Thread del main");
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    
}
