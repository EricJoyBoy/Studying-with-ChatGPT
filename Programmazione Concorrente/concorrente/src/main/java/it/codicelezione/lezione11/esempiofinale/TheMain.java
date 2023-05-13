package it.codicelezione.lezione11.esempiofinale;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.*;

public class TheMain {
    public static void main(String[] args)
    throws IOException, ClassNotFoundException {
DemoClass p = new DemoClass(true);
try (ObjectOutput os = new ObjectOutputStream(new FileOutputStream("pippo.ser"))) {
    DemoClass.incSdat();
    DemoClass.incSdat();
    System.out.println(p);
    os.writeObject(p); // chiama DemoClass.writeObject
    os.flush();
    os.close();
}
DemoClass.incSdat();
DemoClass.incSdat();
ObjectInput is = new ObjectInputStream(new FileInputStream("pippo.ser"));
DemoClass p1 = (DemoClass) is.readObject();
System.out.println(p1);
is.close();
}
}
