package it.codicelezione.lezione08.multiserver.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    InetAddress addr;
    Socket socket;

    Client() throws UnknownHostException{
        try {
			addr = InetAddress.getByName(null);
		} catch (UnknownHostException e) {
			System.err.println("JabberClient: could not get IP address");
			System.exit(0);
		}
		System.out.println("addr = " + addr);

    }

    void exec(String myName) throws IOException, InterruptedException{
        socket = new Socket(addr, 8081);
        System.out.println("socket = " + socket); 
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1500);
            out.println("hello " + i +" from "+myName);
            String str = in.readLine();
            System.out.println(str);
        }
        

    }

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new Client().exec(args.length==0?"anonymous":args[0]);
	}
    
}
