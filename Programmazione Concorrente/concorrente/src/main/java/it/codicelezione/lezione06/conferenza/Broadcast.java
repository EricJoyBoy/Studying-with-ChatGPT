package it.codicelezione.lezione06.conferenza;

public class Broadcast<Data> {
    private Data theMessage;
    private boolean arrived;
    private int waiting;

    public Broadcast(){
        this.arrived = false;
        this.waiting = 0;
    }

    public synchronized void send(Data message){
        if(waiting!=0 && !arrived) {
			theMessage = message;
			arrived = true;
			notifyAll();
		}
    }
    

    public synchronized Data receive() throws InterruptedException{
        try{
        while(!arrived){
            waiting++;
            wait();
            waiting--;
        }
        if(waiting==0) {
            // The last thread to receive the message resets the flag
            arrived = false ;
        }
    } catch(InterruptedException e){
        if (--waiting == 0)
				arrived = false;
    }
        return theMessage;
    }
}
