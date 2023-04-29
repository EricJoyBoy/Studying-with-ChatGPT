package it.codicelezione.lezione05.fivefilosofirandomwait;

public class Chopstick {
    public enum State {AVAILABLE, BUSY}
    private State state;
    private int id;
    public Chopstick(int id){
        this.id = id;
        this.state = Chopstick.State.AVAILABLE;
    }

    public synchronized void leave(){
        this.state = Chopstick.State.AVAILABLE;
        notify();
    }

    public String getName(){
        return "Filosofo " +id;
    }

    public synchronized boolean take(long t) throws InterruptedException{
        boolean isOccupato = state==Chopstick.State.BUSY;
        if(t==0){
            while(isOccupato){
                wait();
            }
            this.state = Chopstick.State.BUSY;
            return (true);
        }else{
            while (isOccupato) {
                wait(t);
                if(!isOccupato){
                    break;
                }else{
                    notifyAll();
                    return false;
                }
            }
            this.state = Chopstick.State.BUSY;
            return true;
        }
    }
}
