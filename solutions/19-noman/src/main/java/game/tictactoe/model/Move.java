package game.tictactoe.model;

public class Move {
	
	private final int x;
	private final int y;
	private final CellState cellState;
	
	public Move(int x, int y, CellState cellState) {
		this.x = x;
		this.y = y;
		this.cellState = cellState;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public CellState getCellState() {
		return cellState;
	}
}
