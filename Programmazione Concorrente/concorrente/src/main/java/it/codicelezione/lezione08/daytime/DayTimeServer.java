package it.codicelezione.lezione08.daytime;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Date;


public class DayTimeServer {
    public final static int DayTime_PORT = 1333;
    ServerSocket server;
    Socket connection; 
    DayTimeServer() throws IOException{
        server = new ServerSocket(DayTime_PORT);
    }

    private void exec(){
        while(true){
            try{
                connection = server.accept();
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
                connection.close();
            }catch(IOException e){

            }
        }
    }
    public static void main(String[] args) {
		DayTimeServer srv;
		try {
			srv = new DayTimeServer();
			srv.exec();
		} catch (IOException e) {
			System.out.println("Server start failed.");
            e.printStackTrace();
		}
	}
    
}
