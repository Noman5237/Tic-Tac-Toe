package game.tictactoe.model;

public class Board {
	
	private final CellState[][] cellStates;
	public static final int SIZE = 3;
	
	public Board() {
		this.cellStates = new CellState[SIZE][SIZE];
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				this.setCellState(x, y, CellState.EMPTY);
			}
		}
	}
	
	CellState getCellState(int x, int y) {
		return this.cellStates[y][x];
	}
	
	void setCellState(int x, int y, CellState cellState) {
		this.cellStates[y][x] = cellState;
	}
}
