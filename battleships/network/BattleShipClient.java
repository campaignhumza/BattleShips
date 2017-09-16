package battleships.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class BattleShipClient implements Runnable {

	String ip;
	int port;
	private Socket clientSocket = null;
	InetAddress addr = null;
	DataOutputStream outToServer;
	DataInputStream inFromServer;
	private boolean connected = false;

	public BattleShipClient(String ip, int port) {
		this.ip = ip;
		this.port = port;

	}

	
	public boolean isConnected() {
		return connected;
	}
	
	public void setIpAndPort(String ip,int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void writeToServer(String str) throws IOException {
		outToServer.writeUTF(str);
	}
	
	public String recieveFromServer() throws IOException {
		return inFromServer.readUTF();
	}
	

	public void run() {
			try {
				addr = InetAddress.getByName(ip);
				System.out.println("Client connecting to " + addr.toString() + " on port " + port);
				clientSocket = new Socket(addr, port);
				System.out.println("Client just connected to " + clientSocket.getRemoteSocketAddress());
				outToServer = new DataOutputStream(clientSocket.getOutputStream());
			    inFromServer = new DataInputStream(clientSocket.getInputStream());
			    System.out.println(inFromServer.readUTF());
			    connected = true;
			    System.out.println("this is the client in clientclass");
			} catch (UnknownHostException e) {
				System.out.print("Unkown host try again:");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	
	public void closeClient() {
		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
