package it.codicelezione.lezione03.semaforocoda;

import java.util.concurrent.Semaphore;

public class Coda {
    static int BUFFERSIZE;
	private int numItems = 0;
	private int[] valori;
	private int first, last;
    Semaphore mutex;

    Coda(int size){
		BUFFERSIZE=size;
		mutex = new Semaphore(1);
		first=0; last=0;
		valori=new int[BUFFERSIZE];
	}

    void printWithName(String s, int v) {
		System.out.println(Thread.currentThread().getName()+s+v+"["+numItems+"]");		
	}


    public int getItem(){
        int tmp;
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (numItems == 0) {
            System.err.print("lettura di buffer vuoto!\n");
			System.exit(0);
        }
        numItems--;
        tmp = valori[first];
        first=(first+1)%BUFFERSIZE;
        printWithName(" letto ", tmp);
        mutex.release();
        return tmp;
    }

    public void setItem(int v) {
		try{
			mutex.acquire();
		} catch(InterruptedException e) {}
		if(numItems==BUFFERSIZE){
			System.err.print("scrittura di buffer pieno!\n");
			System.exit(0);
		}
		valori[last]=v;
		last=(last+1)%BUFFERSIZE;
		numItems++;
		printWithName(" scritto ", v);
		mutex.release();
	}

    public int getCurrentSize(){
		return numItems;
	}

}
