package it.codicelezione.lezione08.daytime;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class DayTimeClient {
    InetAddress addr;
    Socket connection; 
    BufferedReader in;
    DayTimeClient(String servName) throws IOException {
        addr = InetAddress.getByName(servName);
        System.out.println("Addr = " + addr);
        connection = new Socket(addr, DayTimeServer.DayTime_PORT);
    }
        private void exec() {
            String str;
            try {
                str = in.readLine();
                System.out.println(str);
            } catch (IOException e) {
                System.out.println("Daytime reading failed");
            }
            finally {
                try { connection.close();
                } catch (IOException e) {}
            }
        }
    
    public static void main(String[] args) {
		DayTimeClient cli;
		try {
			cli = new DayTimeClient("localhost");
			cli.exec();
		} catch (IOException e) {
			System.out.println("Client: connection failed");
		} 
    }
}
    

