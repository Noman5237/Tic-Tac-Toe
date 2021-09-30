package game.tictactoe.players.ai;

import game.tictactoe.managers.GameManager;
import game.tictactoe.models.Board;
import game.tictactoe.models.Move;
import game.tictactoe.players.Player;
import game.tictactoe.states.CellState;

public abstract class AIPlayer extends Player {
	
	public AIPlayer(CellState playerSymbol) {
		super(playerSymbol);
	}
	
	@Override
	public void promptForNextMove(Board board) {
		GameManager.getInstance().setNextMove(this.generateNextMove(board));
	}
	
	public abstract Move generateNextMove(Board board);
}
