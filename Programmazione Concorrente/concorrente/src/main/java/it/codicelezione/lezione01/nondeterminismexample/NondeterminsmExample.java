package it.codicelezione.lezione01.nondeterminismexample;

public class NondeterminsmExample extends Thread{

    final static int numIterations = 10;

    @Override
    public void run() {
        for(int i=0;i<numIterations;i++){
            System.out.println("Nuovo Thread");
        }
    }



    public static void main(String[] args) {
        NondeterminsmExample t = new NondeterminsmExample();
        t.start();
        for(int i = 0; i < numIterations;i++){
            System.out.println("Main");
        }

    }
    
}
