package it.codicelezione.lezione08.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
    BufferedReader inFromUser;
	DatagramSocket clientSocket;
	InetAddress IPAddress;
	byte[] sendData;
	byte[] receiveData;
	/**
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	UDPClient() throws SocketException, UnknownHostException{
		inFromUser = new BufferedReader(new InputStreamReader(System.in));
		clientSocket = new DatagramSocket();
		IPAddress = InetAddress.getByName("localhost");
		sendData = new byte[1024];
		receiveData = new byte[1024];
	}
	private void exec() throws IOException {
		System.out.println("type a string: ");
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket =
				new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence=new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}
	public static void main(String args[]) {
		try {
			UDPClient cli = new UDPClient();
			cli.exec();
		} catch (IOException e) {
			System.out.println("Client failed");
		}
	}
}
