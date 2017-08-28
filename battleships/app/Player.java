package battleships.app;

public class Player {
	
	private PlayerBoard myBoard;
	private OppsBoard oppsBoard;
	
	
	public Player() {
		this.myBoard = new PlayerBoard();
		this.oppsBoard = new OppsBoard();
	}
	
	public boolean isHit(String cell) {
		return myBoard.isHit(cell);
	}
	
	public void oppsBoardUpdate(String cell,boolean hit) {
		oppsBoard.update(cell,hit);
	}
	
	public void takeHit(String cell) {
		myBoard.update(cell);
	}
	
	
	public void placeShips() {
		for(int i = 0; i < 5; i++) {
			myBoard.placeRandom();
		}
	}
	
	public void placeShip(String ship,String startPos,String endPos) {
		
	}
	
	
	public boolean guessAlreadyDone(String cell) {
		return oppsBoard.isAlreadyDone(cell);
	}
	
	
	public boolean isLose() {
		return myBoard.allDestroyed();
	}
	
	
	public boolean isWin() {
		return !isLose();
	}
	
	public String playerBoardToString() {
		return myBoard.toString();
	}
	
	public String oppsBoardToString() {
		return oppsBoard.toString();
	}
	
	public String toString() {
		String out = "";
		out += playerBoardToString();
		out += "\n";
		out += oppsBoardToString();
		out += "\n";
		return out;
	}
	
	
	

}
