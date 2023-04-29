package it.codicelezione.lezione08.multiservermulticlient.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSlave extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerSlave(Socket s) throws IOException{
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start();

    }
    
    public void run(){
        boolean finito = false;
        while(!finito){
            try {
                String str = in.readLine();
                if (str.equals("END")) {
					finito=true;
				} else {
					System.out.println("Echoing: " + str);
					out.println(str);
				}
                System.out.println("closing...");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally{
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
