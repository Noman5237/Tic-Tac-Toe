package game.tictactoe.model;

public enum CellState {
	EMPTY,
	X,
	O;
	
	public boolean equals(CellState... cellStates) {
		for (CellState cellState : cellStates) {
			if (cellState != this) return false;
		}
		
		return true;
	}
}
