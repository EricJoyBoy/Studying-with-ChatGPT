package it.codicelezione.lezione08.multiservermulticlient.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class MultiClient {
    static final int MAX_THREADS = 4;
	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress addr = InetAddress.getByName(null);
		while (Client.threadTotalCount()<20) {
			if (Client.threadCount() < MAX_THREADS) {
				new Client(addr);        
				Thread.sleep(ThreadLocalRandom.current().nextInt(100));
			} else {
				Thread.sleep(ThreadLocalRandom.current().nextInt(10));
			}
		}
	}
    
}
