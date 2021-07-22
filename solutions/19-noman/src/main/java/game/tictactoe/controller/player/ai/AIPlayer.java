package game.tictactoe.controller.player.ai;

import game.tictactoe.controller.player.Player;
import game.tictactoe.manager.GameManager;
import game.tictactoe.model.Board;
import game.tictactoe.model.CellState;
import game.tictactoe.model.Move;

public abstract class AIPlayer extends Player {
	
	public AIPlayer(CellState playerSymbol) {
		super(playerSymbol);
	}
	
	@Override
	public void promptForNextMove(Board board) {
		GameManager.getInstance().setNextMove(generateNextMove(board));
	}
	
	public abstract Move generateNextMove(Board board);
}
