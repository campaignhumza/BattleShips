package battleships.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

import battleships.app.GameEngine;
import battleships.app.Player;

public class BattleShipServer implements Runnable {
	
	private ServerSocket serverSocket;
	private Socket client;
	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	private boolean connected = false;
	private Player player1 = new Player();
	private Player player2 = new Player();
	


	public BattleShipServer() throws IOException {
		serverSocket = new ServerSocket(0);
	}
	
	public DataInputStream getInFromClient() {
		return inFromClient;
	}
	
	public DataOutputStream outToClient() {
		return outToClient;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void writeToClient(String str) {
		try {
			outToClient.writeUTF(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String receiveFromClient() throws IOException {
		return inFromClient.readUTF();
	}
	
	
	
	public void run() {
	      while(!connected) {
	         try {
	     
	        	    InetAddress ip = InetAddress.getLocalHost();
		        System.out.println("Server waiting for opponent on ip/port : " + ip.getHostAddress() +"/" + serverSocket.getLocalPort() + "...");
				System.out.println("alternatively enter opponents ip and port, ip:");

	            client = serverSocket.accept();
	            System.out.println("Server just connected to " + client.getRemoteSocketAddress());
	            inFromClient = new DataInputStream(client.getInputStream());
	            outToClient = new DataOutputStream(client.getOutputStream());
	            
	            outToClient.writeUTF("CONNECTED!");
	            connected = true;
	  	      //runGame();
	         }catch(SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	
	public void runGame() throws IOException {
		Scanner reader = new Scanner(System.in);
		player1.placeShips();
		player2.placeShips();
		String guesstimate;
		boolean hit;
		System.out.println("Instructions: enter position to bomb as shown in grid e.g A10");
		writeToClient("Instructions: enter position to bomb as shown in grid e.g A10");
		while(!player1.isLose() && !player2.isLose()) {
			//player 1's turn
			System.out.println(player1.toString());
			System.out.println("Player 1's turn:");
				guesstimate = reader.next();
				System.out.println(guesstimate);
				while (!isValidGuess(guesstimate) || player1.guessAlreadyDone(guesstimate)) {
					guesstimate = reader.next();
				}
				hit = player2.isHit(guesstimate);
				player1.oppsBoardUpdate(guesstimate,hit);
				if(hit) {
					player2.takeHit(guesstimate);
				}
		
				//player 2's turn
			if (!player2.isLose()) {
				//writeToClient(player2.toString());
				//writeToClient("Player 2's turn:");
				System.out.println(player2.toString());
				System.out.println("Player 2's turn:");
				//guesstimate = reader.next();
				guesstimate = receiveFromClient();
				while (!isValidGuess(guesstimate) || player1.guessAlreadyDone(guesstimate)) {
					guesstimate = receiveFromClient();
				}
				hit = player1.isHit(guesstimate);
				player2.oppsBoardUpdate(guesstimate,hit);
				if(hit) {
					player1.takeHit(guesstimate);
				}
			}
		}
		
		reader.close();
		
		if(player2.isLose()) {
			System.out.println("Player 1 Wins");
			writeToClient("Player 1 Wins");
		} else {
			System.out.println("Player 2 Wins");
			writeToClient("Player 2 Wins");
		}
	}
	
	public boolean isValidGuess(String guesstimate) {
		if(guesstimate.length() > 3 || guesstimate.length() < 2) {
			System.out.println("This move isn't valid, "
					+ "specify move according to cell (e.g E6) and press Enter.");
			return false;
		}
		String integer;
		if(guesstimate.length() == 3) {
			integer = guesstimate.substring(1,2);
		} else {
			integer = guesstimate.substring(1);
		}
			if (!isValidLetter(guesstimate.charAt(0)) || !isValidInt(Integer.parseInt(integer))) {
				System.out.println("This move isn't valid, "
						+ "specify move according to cell (e.g E6) and press Enter.");
				return false;
			} else {
				return true;
			}
		}
	
	public boolean isValidLetter(char c) {
		return ('A' <= c && c <= 'J') || 
				('a' <= c && c <= 'j'); 
	}
	
	public boolean isValidInt(int index) {
		return (1 <= index && index <= 10 );
	}
	
	public void closeServer() {
		if(connected) {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
