Ecco un esempio di codice Java che legge un numero intero dall'input dell'utente utilizzando le classi di input/output di java.io:

```java
import java.io.*;

public class LeggiNumero {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numero = 0;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                System.out.print("Inserisci un numero intero: ");
                numero = Integer.parseInt(br.readLine());
                inputValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: input non valido. Inserisci un numero intero.");
            }
        }

        System.out.println("Hai inserito il numero " + numero);
    }

}

```

n questo esempio, viene creato un oggetto BufferedReader che legge l'input dell'utente dall'oggetto System.in di tipo InputStream. Viene quindi utilizzata una variabile booleana inputValido per controllare se l'utente ha inserito un input valido (in questo caso, un numero intero). Se l'utente inserisce un input non valido, viene generata un'eccezione NumberFormatException, che viene catturata all'interno di un blocco catch e viene stampato un messaggio di errore. L'utente viene quindi richiesto di inserire un nuovo input. Se l'utente inserisce un input valido, viene utilizzato il metodo parseInt della classe Integer per convertire l'input da una stringa in un intero. Il numero intero viene quindi assegnato alla variabile numero e viene visualizzato a terminale.