Ecco un esempio di implementazione di un sistema di produttore-consumatore utilizzando la classe BlockingQueue di Java, che gestisce automaticamente la sincronizzazione e il coordinamento tra i thread produttore e consumatore. Inoltre, l'esempio prevede l'uso del metodo poll con un timeout per evitare che il thread consumatore rimanga bloccato all'infinito in caso la coda rimanga vuota:


```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProdCons {

    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(1); // Coda condivisa con dimensione massima 1

        Thread prod = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.put(i); // Produzione
                    System.out.println("Prodotto: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread cons = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Integer val = buffer.poll(1, TimeUnit.SECONDS); // Consumo con timeout di 1 secondo
                    if (val != null) {
                        System.out.println("Consumato: " + val);
                    } else {
                        System.out.println("Timeout di attesa scaduto");
                    }
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


In questo esempio, il produttore produce numeri interi e li inserisce nella coda buffer condivisa, utilizzando il metodo put della classe BlockingQueue che blocca il thread produttore se la coda è piena. Il consumatore preleva i numeri dalla coda condivisa, utilizzando il metodo poll con un timeout di 1 secondo che blocca il thread consumatore se la coda è vuota, ma lo fa ripartire dopo il tempo limite specificato. In questo modo, la sincronizzazione e il coordinamento tra i thread produttore e consumatore sono gestiti automaticamente dalla classe BlockingQueue, senza necessità di utilizzare esplicitamente semafori o metodi wait e notify.