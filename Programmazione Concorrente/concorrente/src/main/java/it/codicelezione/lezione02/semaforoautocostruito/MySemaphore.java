package it.codicelezione.lezione02.semaforoautocostruito;

public class MySemaphore {
    private int value;
	MySemaphore (int init) {
		value = init;
	}
	synchronized public void release() {
		value++;
		notify();
	}
	synchronized public void acquire() throws InterruptedException {
		while (value == 0)  // NB: while, non if!
			wait();
		value--;
	}
}
