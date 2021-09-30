package game.tictactoe.players.ai;

import game.tictactoe.models.Board;
import game.tictactoe.models.Move;
import game.tictactoe.states.CellState;

public class IntelligentAIPlayer extends AIPlayer {
	
	public IntelligentAIPlayer(CellState playerSymbol) {
		super(playerSymbol);
	}
	
	@Override
	public Move generateNextMove(Board board) {
		return null;
	}
}
