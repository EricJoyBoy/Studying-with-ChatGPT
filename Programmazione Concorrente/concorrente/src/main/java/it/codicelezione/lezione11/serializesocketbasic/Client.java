package it.codicelezione.lezione11.serializesocketbasic;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    void exec(){
        Socket socket=null;
		InetAddress addr=null;
		System.out.println("Client starts");
    

        try {
			addr = InetAddress.getByName(null);
			socket = new Socket(addr, Server.PORT);
			ObjectOutputStream obj_out_s = new ObjectOutputStream(socket.getOutputStream());
			Employee empl=new Employee("Emerenziano Paronzini", 123, 3000);
			empl.display();
			obj_out_s.writeObject(empl);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("closing...");
			try { socket.close(); } catch (IOException e) { }
		}
		System.out.println("Client finished");
    }

    public static void main(String[] args) {
		new Client().exec();
	}
}
