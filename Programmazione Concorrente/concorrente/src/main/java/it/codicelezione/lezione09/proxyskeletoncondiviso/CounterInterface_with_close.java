package it.codicelezione.lezione09.proxyskeletoncondiviso;

import java.io.IOException;

public interface CounterInterface_with_close extends CounterInterface{
	public void close() throws IOException;
}