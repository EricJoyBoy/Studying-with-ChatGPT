Ecco un esempio di codice Java che crea un thread passando un'istanza di Runnable e scrive output sullo standard output:


```java
public class Main {
    public static void main(String[] args) {
        // crea un'istanza di Runnable
        Runnable runnable = new MyRunnable();

        // crea un nuovo thread e passa l'istanza di runnable al costruttore
        Thread thread = new Thread(runnable);

        // avvia il thread
        thread.start();

        // scrive tre volte sullo standard output
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        // scrive tre volte sullo standard output
        for (int i = 0; i < 3; i++) {
            System.out.println("thread");
        }
    }
}


```


In questo esempio, la classe Main contiene il metodo main, che crea un'istanza di MyRunnable e la passa al costruttore di Thread. Viene quindi avviato il thread con il metodo start e viene eseguito il ciclo for che scrive "main" tre volte sullo standard output.

La classe MyRunnable implementa l'interfaccia Runnable e contiene il metodo run, che esegue il ciclo for e scrive "thread" tre volte sullo standard output. Quando il thread viene avviato, il metodo run di MyRunnable viene eseguito in parallelo al metodo main di Main.