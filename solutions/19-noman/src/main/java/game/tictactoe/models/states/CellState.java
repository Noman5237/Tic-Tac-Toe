package game.tictactoe.models.states;

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
