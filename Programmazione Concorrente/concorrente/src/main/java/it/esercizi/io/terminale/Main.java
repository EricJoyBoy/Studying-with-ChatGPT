package it.esercizi.io.terminale;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in; // permette di leggere da terminale
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream); 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // permette di leggere una riga intera

            System.out.print("Inserisci un numero intero: "); // 
            int numero = Integer.parseInt(bufferedReader.readLine()); // legge una riga intera e la converte in un numero intero
            System.out.println("Hai inserito il numero: " + numero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



