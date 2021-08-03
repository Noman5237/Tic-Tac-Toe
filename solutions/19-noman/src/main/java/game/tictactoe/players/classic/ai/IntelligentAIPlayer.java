package game.tictactoe.players.classic.ai;

import game.tictactoe.models.Board;
import game.tictactoe.models.states.CellState;
import game.tictactoe.models.Move;

public class IntelligentAIPlayer extends AIPlayer {
	
	public IntelligentAIPlayer(CellState playerSymbol) {
		super(playerSymbol);
	}
	
	@Override
	public Move generateNextMove(Board board) {
		return null;
	}
}
