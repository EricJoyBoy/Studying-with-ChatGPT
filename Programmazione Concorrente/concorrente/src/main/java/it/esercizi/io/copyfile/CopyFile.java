package it.esercizi.io.copyfile;

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
