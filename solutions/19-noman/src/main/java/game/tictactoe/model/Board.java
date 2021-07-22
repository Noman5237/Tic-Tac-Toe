package game.tictactoe.model;

public class Board {
	
	public static final int SIZE = 3;
	
	private final CellState[][] cellStates;
	
	public Board() {
		this.cellStates = new CellState[SIZE][SIZE];
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				this.setCellState(x, y, CellState.EMPTY);
			}
		}
	}
	
	public CellState getCellState(int x, int y) {
		return this.cellStates[y][x];
	}
	
	public void setCellState(int x, int y, CellState cellState) {
		if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return;
		this.cellStates[y][x] = cellState;
	}
	
	public Board copy() {
		Board clone = new Board();
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				clone.setCellState(x, y, this.getCellState(x, y));
			}
		}
		
		return clone;
	}
}
