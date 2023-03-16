package it.esercizi.io.testo;


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
