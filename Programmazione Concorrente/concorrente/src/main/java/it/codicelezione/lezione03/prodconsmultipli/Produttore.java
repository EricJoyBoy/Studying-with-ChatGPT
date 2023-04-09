package it.codicelezione.lezione03.prodconsmultipli;

public class Produttore extends Thread {
    CellaCondivisa cella;
    public Produttore(String name, CellaCondivisa c){
        super(name);
        this.cella = c; 
    
    }
    

    @Override
    public void run() {
        int i = 0;
        for (;;) {
            cella.setValore(i++);
        }
    
    }
}
