package game.tictactoe.controller.player;

import game.tictactoe.model.Board;
import game.tictactoe.model.CellState;

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
