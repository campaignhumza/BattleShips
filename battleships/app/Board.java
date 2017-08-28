package battleships.app;

import java.util.Random;

public abstract class Board {
	
	
	public String[][] board;
	
	public Board() {
		boardInit();
	}
	
	private void boardInit() {
		char c = 'A';
		int index = 1;
		this.board = new String[11][11];
		
		for (int i = 0; i < board.length;i++) { 
			if(i == 0) {
				board[0][i] = " ";
			} else {
			board[0][i] = Integer.toString(index);
			index++;
			}
		}
		for(int i = 1; i <board.length; i++) {
			board[i][0] = Character.toString(c);
			c++;
		}
		for(int i = 1; i <board.length; i++) {
			for(int j = 1; j <board[0].length; j ++) {
				board[i][j] = "~";
			}
		}
	}
	
	
	public int[] stringToArrayIndex(String cell) {
		cell = cell.toLowerCase();
		char letter = cell.charAt(0);
		int i = letter - 96;
		int j;
		if(cell.length() == 3) {
			j = Integer.parseInt(cell.substring(1, 3));
		} else {
			j = Character.getNumericValue(cell.charAt(1));
		}		
		int[] arr = {i,j};
		return arr;
	}
	
	public void placeRandom() {
		Random random = new Random();
		int i = random.nextInt(10) + 1;
		int j = random.nextInt(10) + 1;
		board[i][j] = "O";
	}

	
public String toString() {
	String boardString = "";
	for(int i = 0; i < board.length; i++) {
		for(int j = 0; j < board[0].length; j++) {
			boardString += board[i][j] + "  ";
			//System.out.print(board[i][j] + "  ");
			
		}
		boardString += "\n";
	}
	return boardString;
	}

}
