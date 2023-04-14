package it.codicelezione.lezione03.semaforo;

import java.util.concurrent.Semaphore;

public class CellaCondivisa {
    
    private int BUFFERSIZE;
	private int numItems = 0;
	private int valore;
	Semaphore mutex;
	CellaCondivisa(int size){
		BUFFERSIZE=size;
		mutex = new Semaphore(1);
	}
	void printWithName(String s) {
		System.out.println(Thread.currentThread().getName()+s+valore+"["+numItems+"]");		
	}
	public int getValore(){
		int tmp;
		try{ mutex.acquire(); } catch(InterruptedException e) {}
		tmp=valore;
		numItems--;
		printWithName(" letto ");
		mutex.release();
		return tmp;
	}

	public void setValore(int v) {
		try{ mutex.acquire(); } catch(InterruptedException e) {}
		valore=v;
		numItems++;
		printWithName(" scritto ");
		mutex.release();
	}
	public int getCuttentSize(){
		return numItems;
	}
}
