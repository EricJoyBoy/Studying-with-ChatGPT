Ecco un esempio di implementazione di un sistema di produttore-consumatore utilizzando la sincronizzazione della coda con i metodi wait e notify in Java:

```java
import java.util.LinkedList;
import java.util.Queue;

public class ProdCons {

    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>(); // Coda condivisa

        Thread prod = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.size() == 1) { // Attende se la coda è piena
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.add(i); // Produzione
                    System.out.println("Prodotto: " + i);
                    buffer.notify(); // Sveglia il consumatore
                }
            }
        });

        Thread cons = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.size() == 0) { // Attende se la coda è vuota
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int val = buffer.poll(); // Consumo
                    System.out.println("Consumato: " + val);
                    buffer.notify(); // Sveglia il produttore
                }
            }
        });

        prod.start();
        cons.start();
    }
}

```

In questo esempio, il produttore produce numeri interi e li inserisce nella coda buffer condivisa, sincronizzando l'accesso alla coda stessa tramite il blocco synchronized e il metodo wait per attendere se la coda è piena e il metodo notify per svegliare il consumatore dopo aver inserito un elemento. Il consumatore preleva i numeri dalla coda condivisa, sincronizzando anch'esso l'accesso alla coda tramite il blocco synchronized e utilizzando il metodo wait per attendere se la coda è vuota e il metodo notify per svegliare il produttore dopo aver prelevato un elemento. In questo modo, la sincronizzazione viene gestita dalla coda stessa, grazie all'uso dei metodi wait e notify per coordinare i thread produttore e consumatore.