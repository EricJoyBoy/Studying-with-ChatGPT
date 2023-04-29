package it.codicelezione.lezione05.fivefilosofiordinati;

public class Chopstick {
    public enum State {AVAILABLE, BUSY}
    private State state;
    private int id;
    public Chopstick(int id){
        this.id = id;
        this.state=Chopstick.State.AVAILABLE;

    }
    
    public synchronized void take() throws InterruptedException{
        boolean isOccupato  = state == Chopstick.State.BUSY;
        while (isOccupato) {
            wait();
            this.state=Chopstick.State.BUSY;
        }
        
    }
    public synchronized void leave() {
		this.state=Chopstick.State.AVAILABLE;
		notify();
	}

    public String getName() { return "f"+id; }
	public int getId() { return this.id; }

}
