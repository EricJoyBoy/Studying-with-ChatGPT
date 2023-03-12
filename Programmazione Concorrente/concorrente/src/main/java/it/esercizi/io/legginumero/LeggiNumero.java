package it.esercizi.io.legginumero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
