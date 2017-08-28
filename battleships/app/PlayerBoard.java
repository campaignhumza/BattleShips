package battleships.app;

public class PlayerBoard extends Board {
	
	
	public PlayerBoard() {
		super();
	}
	
public boolean allDestroyed() {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j ++) {
				if (board[i][j] == "O") {
					return false;
				}
			}
		}
		return true;
	}

public boolean isHit(String cell) {
	int i,j;
	int[] indexes = stringToArrayIndex(cell);
	i = indexes[0];
	j = indexes[1];
	if(board[i][j] == "O") {
		return true;
	} else {
		return false;
	}
}


public void update(String cell) {
	int i,j;
	int[] indexes = stringToArrayIndex(cell);
	i = indexes[0];
	j = indexes[1];
	
		board[i][j] = "X";

}
	
	

}
