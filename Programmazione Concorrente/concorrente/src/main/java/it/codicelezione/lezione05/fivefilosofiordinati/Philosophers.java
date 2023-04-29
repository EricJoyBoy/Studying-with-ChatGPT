package it.codicelezione.lezione05.fivefilosofiordinati;

public class Philosophers extends Thread {
Chopstick right,left;
private String name;

public Philosophers(String id, Chopstick left, Chopstick right) {
    this.name=id;
    this.left=(left.getId()<right.getId())?left:right;
    this.right=(left.getId()<right.getId())?right:left;
}

private void writeState(String action, String stickName) {
    System.out.println("Phil "+name+action+stickName);
}

public void run() {
    while(true) {
        try {
            writeState(": thinking", "");
            Thread.sleep(30);
            writeState(": hungry", "");
            left.take();
            writeState(" picked up ", left.getName());
            right.take();
            writeState(" picked up ", right.getName());
            writeState(": eating", "");
            Thread.sleep(40);
            left.leave();
            writeState(" dropped ", left.getName());
            right.leave();
            writeState(" dropped ", right.getName());
        } catch (InterruptedException e) {return ; }
    }
}
    
}
