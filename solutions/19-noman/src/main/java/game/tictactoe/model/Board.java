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
	
	public Board(Board boardToCopy) {
		this();
		if (boardToCopy == null) {
			return;
		}
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				this.setCellState(x, y, boardToCopy.getCellState(x, y));
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
	
}
