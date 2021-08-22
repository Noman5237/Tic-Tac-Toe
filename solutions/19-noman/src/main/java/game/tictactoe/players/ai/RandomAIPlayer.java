package game.tictactoe.players.ai;

import game.tictactoe.models.Board;
import game.tictactoe.models.Move;
import game.tictactoe.models.states.CellState;

import java.util.Date;
import java.util.Random;

public class RandomAIPlayer extends AIPlayer {
	
	private final Random random;
	
	public RandomAIPlayer(CellState playerSymbol) {
		super(playerSymbol);
		this.random = new Random(new Date().getTime());
	}
	
	@Override
	public Move generateNextMove(Board board) {
		return this.getRandomMove(board);
	}
	
	protected Move getRandomMove(Board board) {
		int x;
		int y;
		do {
			x = this.random.nextInt(Board.SIZE);
			y = this.random.nextInt(Board.SIZE);
			// TODO refactor to a smarter loop
		} while (board.getCellState(x, y) != CellState.EMPTY);
		
		return new Move(x, y, super.getPlayerSymbol());
	}
}
