package it.codicelezione.lezione02.noracesemaphore;

public class Counter {
    long count = 0;

    public void add(long value){
        this.count += value;
    }
}
