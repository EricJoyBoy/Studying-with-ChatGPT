package it.codicelezione.lezione01.daemonexample;

public class DaemonExample extends Thread {

    public DaemonExample(){
        setDaemon(isDaemon());// di default viene messo a true
    }
    
    @Override
    public void run() {
        int count = 0;
        while(true){
            System.out.println("Ciao" + count++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        t1.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Il tread main e terminato");
    }
}
