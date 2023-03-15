package it.esercizi.io.filecopy;

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
