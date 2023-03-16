Ecco qui una possibile implementazione della classe Testo in Java:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Testo {
private String testo;
private List<String> parole;

public Testo(File file) throws FileNotFoundException {
    Scanner scanner = new Scanner(file);
    StringBuilder sb = new StringBuilder();
    while (scanner.hasNextLine()) {
        sb.append(scanner.nextLine());
        sb.append("\n");
    }
    scanner.close();
    testo = sb.toString();
    parole = Arrays.asList(testo.split("\\W+"));
}

public int numeroParole() {
    return parole.size();
}

public int numeroParoleDistinte() {
    Set<String> paroleDistinte = new HashSet<>(parole);
    return paroleDistinte.size();
}

public int contaOccorrenzeParola(String daCercare) {
    int count = 0;
    for (String parola : parole) {
        if (parola.equals(daCercare)) {
            count++;
        }
    }
    return count;
}

public LinkedList<String> paroleDistinteInOrdineAlfabetico() {
    Set<String> paroleDistinte = new TreeSet<>(parole);
    return new LinkedList<>(paroleDistinte);
}

}

```

Il costruttore della classe prende come argomento un oggetto File che rappresenta il file di testo da leggere. Viene creato uno Scanner per leggere il file riga per riga e ogni riga viene aggiunta a un oggetto StringBuilder, insieme ad un carattere di nuova linea per separare le righe. Alla fine, il testo completo viene salvato come una stringa.

La lista delle parole viene ottenuta dividendo il testo in parole usando l'espressione regolare "\W+", che corrisponde a qualsiasi carattere non alfanumerico. Le parole vengono poi memorizzate in una lista di stringhe.

Il metodo numeroParole restituisce semplicemente la lunghezza della lista delle parole.

Il metodo numeroParoleDistinte utilizza un insieme (HashSet) per mantenere le parole distinte e restituisce la dimensione di quest'ultimo.

Il metodo contaOccorrenzeParola scorre la lista delle parole e conta quante volte compare la parola specificata come argomento.

Il metodo paroleDistinteInOrdineAlfabetico utilizza un insieme ordinato (TreeSet) per mantenere le parole distinte in ordine alfabetico e restituisce la lista delle parole distinte come una LinkedList.