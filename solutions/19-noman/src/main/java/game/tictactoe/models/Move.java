package game.tictactoe.models;

import game.tictactoe.states.CellState;

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
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public CellState getCellState() {
		return this.cellState;
	}
}
