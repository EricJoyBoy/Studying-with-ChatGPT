package it.esercizi.io.legginumerointero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeggiNumeroIntero {


    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String inputString;
        int numero;

        do {
            System.out.println("Inserisci un numero intero o scrivi \"Basta\" per terminare:");
            inputString = bufferedReader.readLine();
            try {
                numero = Integer.parseInt(inputString);
                System.out.println("Hai inserito il numero: " + numero);
            } catch (NumberFormatException e) {
                System.out.println("Inserimento terminato.");
            }
        } while (!inputString.equals("Basta"));
    }
    
}
