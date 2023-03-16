Ecco un possibile codice in Java per copiare il contenuto di un file di origine in un file di destinazione, leggendo e scrivendo un carattere alla volta:

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileCopy source_file dest_file");
            System.exit(1);
        }
        
        String sourceFilename = args[0];
        String destFilename = args[1];
        
        try (FileReader reader = new FileReader(sourceFilename);
             FileWriter writer = new FileWriter(destFilename)) {
            
            int c;
            int count = 0;
            while ((c = reader.read()) != -1) {
                writer.write(c);
                count++;
            }
            
            System.out.println("Copied " + count + " characters from " + sourceFilename + " to " + destFilename);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}


```

In questo programma, si leggono i nomi dei file di origine e destinazione dalla linea di comando. Si crea quindi un oggetto FileReader per leggere il file di origine e un oggetto FileWriter per scrivere il file di destinazione. Si legge quindi il contenuto del file di origine un carattere alla volta, utilizzando il metodo read() di FileReader, e si scrive ogni carattere nel file di destinazione, utilizzando il metodo write() di FileWriter. Si tiene traccia del numero di caratteri copiati in una variabile count. Alla fine si stampa un messaggio che riporta il numero di caratteri copiati.

Si noti che nell'esempio si utilizza un costrutto try-with-resources per gestire la chiusura automatica dei file alla fine del blocco di codice. Questo evita di dover esplicitamente chiamare i metodi close() sui file, e garantisce che i file vengano chiusi correttamente anche in caso di eccezioni durante la lettura o scrittura dei file.


