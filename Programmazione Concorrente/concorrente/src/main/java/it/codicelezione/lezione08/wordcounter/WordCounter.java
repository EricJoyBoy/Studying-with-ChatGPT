package it.codicelezione.lezione08.wordcounter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WordCounter extends Thread {
    CyclicBarrier cyclicBarrier;
	public int wordCount=0;
	int startFile, endFile;
	int thePORT;
	InetAddress addrIP;
    WordCounter(String addr, int port, CyclicBarrier c, int start, int end) throws UnknownHostException, IOException {
		cyclicBarrier=c;
		startFile=start;
		endFile=end;
		thePORT=port;
		addrIP = InetAddress.getByName(addr);
		System.out.println("word counter slave ready ");
	}
	public void run() {
		String str;
		Socket socket;
		try {
			socket = new Socket(addrIP, thePORT);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			System.out.println("word counter slave operating on "+startFile+","+endFile);
			out.println(startFile);
			out.println(endFile);
			str = in.readLine();
			wordCount=Integer.parseInt(str);
			System.out.println("word counter slave counted "+wordCount+" words; going to wait");
			cyclicBarrier.await();		
		} catch (IOException | InterruptedException | BrokenBarrierException e1) {
			System.out.println("word counter slave aborting "+e1); return;
		}
		try {
			socket.close();
		} catch (IOException e) { }
	}
    
}
