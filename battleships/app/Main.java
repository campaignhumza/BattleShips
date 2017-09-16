package battleships.app;

import java.io.IOException;
import java.util.Scanner;

import battleships.network.BattleShipClient;
import battleships.network.BattleShipServer;

public class Main {
	
	private static BattleShipServer bss;
	private static BattleShipClient bsc;

	public static void main(String[] args) throws IOException {
		
		//Run a battleship server locally and wait for a connection
		try {
			bss = new BattleShipServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		final Thread serverThread = new Thread(bss);
		serverThread.start();
		
		//read user input creating user client to connect to opponents
		//server whilst waiting for connection on users server
		Scanner read = new Scanner(System.in);
		Thread clientThread;
		while(!bss.isConnected() || !bsc.isConnected()) {
			String ip = "localhost";
			int port = read.nextInt();
			BattleShipClient bsc = new BattleShipClient(ip,port);
			clientThread = new Thread(bsc);
			clientThread.start();
		}
		
		if(bss.isConnected()) {
			System.out.println("this is the server");
		} else if (bsc.isConnected()){
			System.out.println("this is the client");
		}
				
		
		//if this client connects to opponents server then end this server
		//and receive and send strings to and from opponents server
		/*String in = "";
		String out = "";
		if(bsc.isConnected()) {
			bss.closeServer();
			serverThread.interrupt();
			System.out.println("this is the client");
			try {
				in = bsc.recieveFromServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(in);
			
			while(in != "Player 1 Wins" || in != "Player 2 Wins") {
				out = read.next();
				bsc.writeToServer(out);
				in = bsc.recieveFromServer();
			}
		} else {
		}*/
		
	}

}
