package it.codicelezione.lezione08.addressSolver;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPaddrressSolver {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length!=1) {
            System.out.println("Usage : WhoAmI Machine ");
            System.exit(1);
        }
        InetAddress a = InetAddress.getByName(args[0]);
        System.out.println(a);
    }
}
