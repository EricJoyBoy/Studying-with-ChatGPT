package it.codicelezione.lezione02.deadlock;

public class MakeDeadlock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        Thread t1 = new Thread(new LockObjects(a,b));
        Thread t2 = new Thread(new LockObjects(a, b));
        t1.start();t2.start();


    }
}
