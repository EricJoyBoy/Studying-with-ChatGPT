Ecco un possibile codice Java che crea e lancia un thread che scrive "thread" tre volte sullo standard output e il main che scrive "main" tre volte sullo standard output:

```java

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("thread");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creazione e avvio del thread
        MyThread t = new MyThread();
        t.start();

        // Scrittura di "main" tre volte sullo standard output
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
        }
    }
}

```

Il programma crea una classe MyThread che estende la classe Thread e ridefinisce il metodo run(), che viene eseguito quando il thread viene avviato. Nel metodo run() viene scritta la parola "thread" tre volte sullo standard output.

Nel main, viene creato un oggetto della classe MyThread e viene avviato il thread tramite il metodo start(). Poi, nel main, viene scritta la parola "main" tre volte sullo standard output.

```java

 thread
thread
thread
main
main
main

```

