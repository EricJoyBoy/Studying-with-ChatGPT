package it.codicelezione.lezione08.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        new EchoClient().exec();
        
    }

    private void exec() throws IOException {
        String str;
        InetAddress addr = InetAddress.getByName(null);
        System.out.println("Client found addr = " + addr);
        Socket socket = new Socket(addr, 8080);
        try {
			System.out.println("Client connected via socket " + socket); 
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			for (int i = 0; i < 10; i++) {
				str="Hello_" + i;
				out.println(str);
				System.out.println("Client sent to server:"+str);
				str = in.readLine();
				System.out.println("Client received from server:"+str);
			}
			out.println("END");
		} finally {
			System.out.println("Client: closing...");
			socket.close();
		}


    }
}
