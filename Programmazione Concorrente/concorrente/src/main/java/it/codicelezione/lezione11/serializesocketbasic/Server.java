package it.codicelezione.lezione11.serializesocketbasic;

import java.io.*;
import java.net.*;

public class Server {
    public static final int PORT = 9999;
    Employee obj =null;

    Socket socket=null;
	ServerSocket s=null;


    void exec() throws IOException, ClassNotFoundException{
        Socket socket=null;
		ServerSocket s=null;

        s = new ServerSocket(PORT);
		socket = s.accept();
        System.out.println("Connection accepted: " + socket);
        ObjectInputStream obj_in_s =new ObjectInputStream(socket.getInputStream());
        Employee emp = (Employee) obj_in_s.readObject();
			emp.display();
			obj_in_s.close();
			System.out.println("Connection ended");
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Server().exec();
	}
}
