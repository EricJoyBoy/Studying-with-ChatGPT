Ecco un esempio di implementazione di un sistema di produttore-consumatore utilizzando i semafori in Java e con la sincronizzazione fatta nella coda:

```java

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProdCons {

    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>(); // Coda condivisa
        Semaphore semProd = new Semaphore(1); // Semaforo produttore
        Semaphore semCons = new Semaphore(0); // Semaforo consumatore

        Thread prod = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semProd.acquire(); // Acquisisce il semaforo del produttore
                    buffer.add(i); // Produzione
                    System.out.println("Prodotto: " + i);
                    semCons.release(); // Rilascia il semaforo del consumatore
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread cons = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semCons.acquire(); // Acquisisce il semaforo del consumatore
                    int val = buffer.poll(); // Consumo
                    System.out.println("Consumato: " + val);
                    semProd.release(); // Rilascia il semaforo del produttore
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        prod.start();
        cons.start();
    }
}


```
In questo esempio, il produttore produce numeri interi e li inserisce nella coda buffer condivisa, acquisendo prima il semaforo del produttore semProd e rilasciando poi il semaforo del consumatore semCons. Il consumatore preleva i numeri dalla coda condivisa, acquisendo prima il semaforo del consumatore semCons e rilasciando poi il semaforo del produttore semProd. In questo modo, la sincronizzazione viene gestita dalla coda stessa, grazie all'uso dei semafori per garantire l'accesso esclusivo dei thread alla coda condivisa.