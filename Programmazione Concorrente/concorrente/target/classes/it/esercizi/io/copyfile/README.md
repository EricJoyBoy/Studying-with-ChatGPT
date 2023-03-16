Ecco una possibile soluzione in Java per copiare il contenuto di un file di testo sorgente in un file di testo destinazione utilizzando le classi FileReader e FileWriter.

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: CopyFile sourceFile destinationFile");
            return;
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(destinationFile)) {

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

``` 

Il programma controlla che ci siano due argomenti sulla linea di comando, il primo rappresentante il file di origine e il secondo il file di destinazione. In caso contrario, viene visualizzato un messaggio di utilizzo e il programma termina.

Il programma utilizza un try-with-resources per garantire che le risorse siano chiuse correttamente alla fine dell'esecuzione. Viene creato un FileReader per leggere il file di origine e un FileWriter per scrivere il file di destinazione. Il programma legge caratteri dal FileReader finché non raggiunge la fine del file (-1) e scrive ciascun carattere nel FileWriter. In caso di errore, viene stampato un messaggio di errore.

Per utilizzare questo programma, si può compilarlo con il comando "javac CopyFile.java" e poi eseguirlo con il comando "java CopyFile source.txt destination.txt", dove source.txt e destination.txt sono i nomi dei file di origine e destinazione rispettivamente.