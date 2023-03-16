package it.esercizi.io.comandline;

import java.io.File;

public class ComandLineInterpreter {
    public static void main(String[] args) {
        // Se ci sono argomenti sulla linea di comando, utilizza il primo come nome del file/directory
        // Altrimenti utilizza la directory corrente
        String fileName = args.length > 0 ? args[0] : ".";
        
        File file = new File(fileName);
        
        // Verifica se il file/directory esiste
        if (!file.exists()) {
          System.out.println("Il file/directory " + fileName + " non esiste.");
          return;
        }
        
        // Se il file è una directory, stampa la lista dei suoi contenuti
        if (file.isDirectory()) {
          System.out.println("Contenuto della directory " + file.getAbsolutePath() + ":");
          for (File subFile : file.listFiles()) {
            System.out.println(subFile.getName());
          }
        } else { // Altrimenti, stampa il percorso assoluto del file e la sua dimensione in byte
          System.out.println("Il file " + file.getAbsolutePath() + " ha dimensione " + file.length() + " byte.");
        }
      }
    
}
