package it.codicelezione.lezione01.waitjoin;


/*Questo codice definisce il metodo principale di un'applicazione Java. Inizialmente, viene stampato un messaggio di errore sulla console per informare l'utente che i thread stanno per partire.

Successivamente, vengono creati e avviati tre oggetti Thread utilizzando la classe "ExampleWithSleeps". Questi thread verranno eseguiti in parallelo con il thread principale dell'applicazione.

Dopo aver avviato i thread, viene stampato un altro messaggio per indicare che i thread sono stati avviati.

Successivamente, il thread principale entra in uno stato di attesa utilizzando il metodo "join()" su ciascuno dei tre thread creati. Questo significa che il thread principale aspetterà che i thread t1, t2 e t3 terminino prima di procedere.

Se uno dei thread viene interrotto mentre è in attesa, verrà sollevata un'eccezione di tipo InterruptedException.

Infine, quando tutti i thread hanno terminato l'esecuzione, viene stampato un messaggio per indicare che l'applicazione sta per essere chiusa e l'applicazione viene terminata utilizzando il metodo "System.exit(0)". Questo metodo forza l'applicazione ad uscire con uno stato di uscita di 0, il che indica che l'applicazione è stata terminata con successo. */
public class JoinWaitExit {
    public static void main(String[] args) {
        System.err.println("I thread stanno per partire");
		Thread t1 = new ExampleWithSleeps("t1"); t1.start();
		Thread t2 = new ExampleWithSleeps("t2"); t2.start();
		Thread t3 = new ExampleWithSleeps("t3"); t3.start();
		System.err.println("I thread sono partiti\n");
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) { }
		System.err.println("chiude l'applicazione");
		System.exit(0); //chiude l'applicazione in ogni caso
	}
    
}
