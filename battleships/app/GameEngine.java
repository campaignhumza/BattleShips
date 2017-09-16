package battleships.app;

import java.util.Scanner;

public class GameEngine {
	
	
	/*
	public GameEngine() {
		this.player1 = new Player();
		this.player2 = new Player();	
	}
	
	public getOpponentsTurn() {
		
	}
	
	
	public void run() {
		Scanner reader = new Scanner(System.in);
		player1.placeShips();
		player2.placeShips();
		String guesstimate;
		boolean hit;
		System.out.println("Instructions: enter position to bomb  as shown in grid e.g A10");
		while(!player1.isLose() && !player2.isLose()) {
			//player 1's turn
			System.out.println(player1.toString());
			System.out.println("Player 1's turn:");
				guesstimate = reader.next();
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
				System.out.println(player2.toString());
				System.out.println("Player 2's turn:");
				guesstimate = reader.next();
				while (!isValidGuess(guesstimate) || player1.guessAlreadyDone(guesstimate)) {
					guesstimate = reader.next();
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
		} else {
			System.out.println("Player 2 Wins");
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
	*/
}
