Ecco un possibile codice Java che implementa la funzionalità descritta:

```java

import java.util.HashMap;
import java.util.Scanner;

public class Traduttore {

    public static void main(String[] args) {
        // Creazione del dizionario
        HashMap<String, String> dizionario = new HashMap<>();
        dizionario.put("cane", "dog");
        dizionario.put("gatto", "cat");
        dizionario.put("topo", "mouse");
        // ... aggiungere altre parole e traduzioni

        // Lettura della parola da tradurre
        Scanner input = new Scanner(System.in);
        String parola = "";
        while (!parola.equals("<Fine>")) {
            System.out.print("Inserisci una parola in italiano da tradurre in inglese: ");
            parola = input.nextLine();
            if (dizionario.containsKey(parola)) {
                String traduzione = dizionario.get(parola);
                System.out.println("Traduzione: " + traduzione);
            } else if (!parola.equals("<Fine>")) {
                System.out.println("Parola non trovata nel dizionario.");
            }
        }
        input.close();
    }
}


```
