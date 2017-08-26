package battleships.app;

public class Player {
	
	private Board board;
	
	
	public Player() {
		this.board = new Board();
	}
	
	public void setisTurn(boolean b) {
		
	}
	
	public void placeShips() {
		
	}
	
	public void placeShip(String ship,String startPos,String endPos) {
		
	}
	
	public boolean move(String cell) {
		return true;
	}
	
	private int[] stringToArrayIndex(String cell) {
		if (cell.length() > 2) {
			
		}
		int i = 0;
		int j = 0;
		
		int[] indexes = {i,j};
		return indexes;
	}
	
	public boolean isLose() {
		return board.allDestroyed();
	}
	
	public boolean guessAlreadyDone() {
		return false;
	}
	
	public boolean isWin() {
		return !isLose();
	}
	
	public boolean isHit() {
		return true;
	}
	
	

}
