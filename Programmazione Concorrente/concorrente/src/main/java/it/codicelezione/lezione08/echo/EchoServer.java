package it.codicelezione.lezione08.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        new EchoServer().exec();
    }

    public static final int  port = 8080; 
    private void exec() throws IOException {
        ServerSocket s = new ServerSocket(port);
        System.out.println("Server iniziato: "+s);
        try {
			Socket mySocket=s.accept();
			try {
				System.out.println("Server: connection accepted: "+mySocket);
				BufferedReader in=
						new BufferedReader(new InputStreamReader(
								mySocket.getInputStream()));
				PrintWriter out=new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(mySocket.getOutputStream())),
						true);
				while(true) {
					String str=in.readLine();
					if(str.equals("END")) break;
					System.out.println("Server echoing:"+str);
					out.println(str);
				}
			}
			finally {
				System.out.println("Server closing...");
				mySocket.close();
			}
		} finally {
			s.close();
		}
    }
}
