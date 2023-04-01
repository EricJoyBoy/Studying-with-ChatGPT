package it.codicelezione.lezione01.waitjoin;

public class ExampleWithSleeps  extends Thread{

    final static int numIterations = 10;
    public ExampleWithSleeps(String s){
        super(s);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < numIterations; i++) {
            System.out.println("Thread "+getName()+" in esecuzione");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        System.out.println("Thread "+ getName() + " finito.");
    }
}
