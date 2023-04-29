package it.codicelezione.lezione08.multiserver.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSlave extends Thread{
    private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public ServerSlave(Socket s) throws IOException {
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		start();
	}
	public void run() {
		boolean finito=false;
		try {
			while (!finito) {
				String str = in.readLine();
				if (str.equals("END")) {
					finito=true;
				} else {
					System.out.println("Echoing: " + str);
					out.println(str);
				}
			}
			System.out.println("closing...");
		} catch (IOException e) {
			System.err.println("IO Exception");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println("Socket not closed");
			}
		}
	}
}
