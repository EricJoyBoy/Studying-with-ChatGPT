package it.codicelezione.lezione04.pompabenzina;

import javafx.stage.StageStyle;

public class Pompa {
    private static final int LIBERA = 0 ;
	private static final int OCCUPATA = 1 ;
	private int state = LIBERA;
	public Pompa(){
		state=LIBERA;
	}

    synchronized public void occupa() {
        boolean isOccupata = state != LIBERA;
		try {
			while(isOccupata)
				wait();
			state = OCCUPATA;
			notifyAll();
		} catch(InterruptedException e) {}
	}
	synchronized public void eroga(int attesa) {
        boolean isLibera = state != OCCUPATA;
		try {
			while(isLibera)
				wait();
			Thread.sleep(attesa);
		} catch(InterruptedException e) { }
	}
	synchronized public void lascia() {
        boolean isLibera =  state != OCCUPATA;
		try {
			while(isLibera)
				wait();
			Thread.sleep(40);
			state = LIBERA;
			notifyAll();
		} catch(InterruptedException e) {}
	}
}
