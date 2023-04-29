package it.codicelezione.lezione04.pompabenzina;

public class StazioneServizio {
    
    static final int QUANTE_AUTO = 10;
    Thread autoThreads[] = new Thread[QUANTE_AUTO];
    public static void main(String[] args) {
        Thread autoThreads[] = new Thread[QUANTE_AUTO];
		try {
			Pompa laPompa = new Pompa();
			for (int i=0; i< QUANTE_AUTO; i++) {
				Auto auto = new Auto(i, laPompa);
				(autoThreads[i] = new Thread(auto)).start();
			}
			for(int i=0; i< QUANTE_AUTO; i++) {
				autoThreads[i].join();
			}
		} catch(InterruptedException e) {}
        
		System.out.println("Tempo medio rifornimento = "+ Auto.calcMedia());
    }
}
