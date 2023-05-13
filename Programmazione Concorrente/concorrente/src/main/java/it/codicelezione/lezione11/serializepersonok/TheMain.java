package it.codicelezione.lezione11.serializepersonok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TheMain {
    String fileName;
	ObjectOutputStream output=null;
	ObjectInputStream ois = null;

	TheMain(String fn) throws FileNotFoundException, IOException{
		fileName=fn;
		output=new ObjectOutputStream(new FileOutputStream(fileName));
		ois = new ObjectInputStream(new FileInputStream(fileName));
	}
	void exec() {
		Employee empl=new Employee("Rossi", 100, 3000);
		empl.display();
		try {
			output.writeObject(empl);
			output.close();
		} catch (IOException e) {
			System.err.println("Problems serializing");
			return;
		}
		System.out.println("Serializzazione completata.");
		Employee newEmpl=null;
		try {
			newEmpl = (Employee) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Problems de-serializing");
			return;
		}
		newEmpl.display();
	}

}
