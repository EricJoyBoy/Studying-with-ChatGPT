package it.codicelezione.lezione11.persistentclock;

import java.io.IOException;

public class TheMainClock {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
		PersistentClock pc = new PersistentClock(1000);
	}
}
