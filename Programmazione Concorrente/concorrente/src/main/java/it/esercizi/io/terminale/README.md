Ecco un esempio di come leggere un numero intero dalla console e visualizzarlo utilizzando le classi di input/output di Java:

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.print("Inserisci un numero intero: ");
            int numero = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Hai inserito il numero: " + numero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
In questo esempio, creiamo un oggetto InputStream usando System.in, che rappresenta l'input standard (ovvero la console). Successivamente, creiamo un oggetto InputStreamReader per convertire il flusso di byte in caratteri e un oggetto BufferedReader per leggere l'input dall'utente in modo efficiente.

Chiediamo all'utente di inserire un numero intero tramite System.out.print, quindi leggiamo l'input dall'utente usando bufferedReader.readLine() e lo convertiamo in un numero intero utilizzando Integer.parseInt(). Infine, visualizziamo il numero inserito utilizzando System.out.println.

Si noti che abbiamo incluso un try-catch per gestire eventuali eccezioni di input/output.
