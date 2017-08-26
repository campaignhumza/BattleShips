package battleships.app;

import java.util.Scanner;

public class GameEngine {
	
	private Player player1;
	private Player player2;
	public enum Ships {
		AIR_CRAFT_CARRIER, BATTLE_SHIP, SUBMARINE,
		CRUISER, DESTROYER
	}
	
	public GameEngine() {
		this.player1 = new Player();
		this.player2 = new Player();	
	}
	
	
	public void run() {
		//players place ships, player 1 always goes first 
		//TO DO: roll dice to choose who goes first
		Scanner reader = new Scanner(System.in);
		player1.placeShips();
		player2.placeShips();
		player1.setisTurn(true);
		player2.setisTurn(false);
		String guesstimate;
		while(!player1.isWin() && !player2.isWin()) {
			//player 1's turn
				guesstimate = reader.next();
				while (!isValidGuess(guesstimate) || player2.guessAlreadyDone()) {
					guesstimate = reader.next();
				}
				player2.move(guesstimate);
		
			if (!player1.isWin()) {
				//player 2's turn
				guesstimate = reader.next();
				while (!isValidGuess(guesstimate)) {
					guesstimate = reader.next();
				}
				player1.move(guesstimate);
			}
		}
		
		reader.close();
		if(player1.isWin()) {
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
	
}
