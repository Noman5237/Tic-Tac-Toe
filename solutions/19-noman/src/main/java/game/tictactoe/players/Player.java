package game.tictactoe.players;

import game.tictactoe.models.Board;
import game.tictactoe.models.states.CellState;

public abstract class Player {
	
	private final CellState playerSymbol;
	
	public Player(CellState playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
	
	public abstract void promptForNextMove(Board board);
	
	public CellState getPlayerSymbol() {
		return playerSymbol;
	}
}
