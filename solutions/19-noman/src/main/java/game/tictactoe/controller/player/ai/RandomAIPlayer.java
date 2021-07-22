package game.tictactoe.controller.player.ai;

import game.tictactoe.model.Board;
import game.tictactoe.model.CellState;
import game.tictactoe.model.Move;

import java.util.Date;
import java.util.Random;

public class RandomAIPlayer extends AIPlayer {
	
	private final Random random;
	
	public RandomAIPlayer(CellState playerSymbol) {
		super(playerSymbol);
		random = new Random(new Date().getTime());
	}
	
	@Override
	public Move generateNextMove(Board board) {
		int x;
		int y;
		do {
			x = random.nextInt(Board.SIZE);
			y = random.nextInt(Board.SIZE);
			// refactor to a smarter loop
		} while (board.getCellState(x, y) != CellState.EMPTY);
		
		return new Move(x, y, super.getPlayerSymbol());
	}
}
