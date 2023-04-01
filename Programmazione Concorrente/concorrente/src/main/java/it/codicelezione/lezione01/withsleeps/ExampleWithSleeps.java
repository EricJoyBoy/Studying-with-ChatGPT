package it.codicelezione.lezione01.withsleeps;

public class ExampleWithSleeps extends Thread {

    final static int numIterations = 10;
    @Override
    public void run() {
        for (int i = 0; i < numIterations; i++) {
            System.out.println("Nuovo Thread");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExampleWithSleeps t = new ExampleWithSleeps();
        t.start();
        for(int i=0; i<numIterations; i++) {
			System.out.println("Main");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {	}
		}
    }
}
