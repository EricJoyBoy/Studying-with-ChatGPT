package it.codicelezione.lezione01.preemptivetest;
/*Il codice seguente crea una classe chiamata BusyThread che estende la classe Thread. Questo significa che viene creato un nuovo thread di esecuzione che può essere eseguito indipendentemente dal thread principale. Quando questo thread viene avviato, entra nel metodo run() e esegue il codice al suo interno.

Il metodo run() contiene un ciclo infinito che controlla continuamente il valore di una variabile intera chiamata a. Se a è maggiore di 100, incrementa a di 1. In caso contrario, decrementa a di 1. Poiché il valore di a non viene mai modificato al di fuori di questo ciclo, il valore di a oscillerà costantemente tra 100 e -100.

In sostanza, questo codice crea un thread che esegue continuamente un ciclo di attesa impegnativo, senza mai fare effettivamente nulla di utile. Questo può consumare significativamente le risorse della CPU, il che può essere un problema se vengono eseguiti contemporaneamente troppi thread simili.
 */
public class BusyThread extends Thread{
    
    @Override
    public void run() {
        int a = 0;
        while(true){
            if(a>100){
                a=a+1;
            }else{
                a=a-1;
            }
        }
    }

}
