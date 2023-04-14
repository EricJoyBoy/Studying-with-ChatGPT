package it.codicelezione.lezione03.prodconsnaivethreadsafe;

public class CellaCondivisa {
    
   int valore;
   public synchronized int getValore(){
    System.out.println("Letto " + valore );
    return valore;
   }

   public synchronized void setValore(int v){
    System.out.println("Scritto "+ valore);
    this.valore = v;
    
   }
}
