package it.codicelezione.lezione09.proxyskeletonmulti;

import java.io.IOException;

public interface CounterInterface {
    public static final int PORT = 8888;
	  public int sum(int s) throws IOException;
	  public int reset() throws IOException;
	  public int increment() throws IOException;
}
