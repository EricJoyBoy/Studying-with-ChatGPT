package it.esercizi.thread.numberThread;

public class NumberThread extends Thread {
    private int threadNumber;

    public NumberThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + threadNumber + " - iteration " + i);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <N>");
            return;
        }

        int N = Integer.parseInt(args[0]);

        if (N < 1 || N > 5) {
            System.out.println("N must be between 1 and 5");
            return;
        }

        NumberThread[] threads = new NumberThread[N];

        for (int i = 0; i < N; i++) {
            threads[i] = new NumberThread(i + 1);
            threads[i].start();
        }

        for (int i = 0; i < N; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads finished");
    }
}
