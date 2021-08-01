package game.tictactoe.players.classic.ai;

import game.tictactoe.players.classic.Player;
import game.tictactoe.managers.GameManager;
import game.tictactoe.models.Board;
import game.tictactoe.models.states.CellState;
import game.tictactoe.models.Move;

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