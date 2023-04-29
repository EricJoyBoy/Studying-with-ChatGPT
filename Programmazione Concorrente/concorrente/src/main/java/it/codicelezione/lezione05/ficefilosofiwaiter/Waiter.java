package it.codicelezione.lezione05.ficefilosofiwaiter;

public class Waiter {
    public synchronized void takeTwo(Chopstick i, Chopstick j){
        boolean hasBothChopstickAvailable = i.isAvailable() && j.isAvailable();
        while (!hasBothChopstickAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i.take();
            j.take();
        }
    }

    public synchronized void leaveTwo(Chopstick i, Chopstick j){
        i.leave();
        j.leave();
        notifyAll();
    }

}
