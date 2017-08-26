package battleships.app;

public class Board {
	
	private char[][] board;
	
	public Board() {
		this.board = new char[10][10];
	}
	
	public boolean allDestroyed() {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j ++) {
				if (board[i][j] == 'O') {
					return false;
				}
			}
		}
		return true;
	}

}
