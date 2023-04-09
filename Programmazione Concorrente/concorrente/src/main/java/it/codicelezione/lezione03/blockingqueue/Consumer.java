package it.codicelezione.lezione03.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
private BlockingQueue<Message> queue;

public Consumer (BlockingQueue<Message> q) {
    this.queue=q;
}

    @Override
    public void run() {
        Message msg ;
		try {
			// consuming messages until exit message is received
			while((msg = queue.take()).getMsg()!="exit") {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName()+" consumed "+msg.getMsg());
			}
			System.out.println("Consumer finished");
		} catch (InterruptedException e) { }
	}
        
    }
    

