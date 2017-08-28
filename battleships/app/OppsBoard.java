package battleships.app;

public class OppsBoard extends Board {
	
	//private String[][] board; 
	
	public OppsBoard() {
		super();
	}

	
	public void update(String cell,boolean hit) {
		int i,j;
		int[] indexes = stringToArrayIndex(cell);
		i = indexes[0];
		j = indexes[1];
		if(hit == true) {
			board[i][j] = "X";
		} else {
			board[i][j] = "*";
		}			
	}
	
	
	public boolean isAlreadyDone(String cell) {
		int i,j;
		int[] indexes = stringToArrayIndex(cell);
		i = indexes[0];
		j = indexes[1];
		if(board[i][j] == "X" || board[i][j] == "*") {
			System.out.println("You've already bombed this position, try another:");
			return true;
		} else {
			return false;
		}
	}
	
	

}
