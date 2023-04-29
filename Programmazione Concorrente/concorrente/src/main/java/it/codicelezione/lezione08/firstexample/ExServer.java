package it.codicelezione.lezione08.firstexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ExServer {
    public static final int port = 8081;

    public static void main(String[] args) throws IOException {
        new ExServer().exec();
    }

    private void exec() throws IOException {
        ServerSocket s = new ServerSocket(port);
        System.out.println("Server Partito " + s);
        try {
			Socket mySocket=s.accept();
			try {
				System.out.println("Server: connection accepted: "+mySocket);
				BufferedReader in=
						new BufferedReader(new InputStreamReader(
								mySocket.getInputStream()));
				while(true) {
					String str=in.readLine();
					if(str.equals("END")) break;
					System.out.println("Server received:"+str);
				}
			}
			finally {
				System.out.println("Server: closing...");
				mySocket.close();
			}
		} finally {
			s.close();
		}


    }
}
