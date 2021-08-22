package game.tictactoe.players.ai;

import game.tictactoe.models.Board;
import game.tictactoe.models.Move;
import game.tictactoe.models.states.CellState;

import java.util.Objects;

public class DefensiveAIPlayer extends RandomAIPlayer {
	
	public DefensiveAIPlayer(CellState playerSymbol) {
		super(playerSymbol);
	}
	
	@Override
	public Move generateNextMove(Board board) {
		Move blockingMove = this.generateMoveToBlockOpponentWin(board);
		if (blockingMove != null) {
			return blockingMove;
		} else {
			return this.getRandomMove(board);
		}
	}
	
	private Move generateMoveToBlockOpponentWin(Board board) {
		int blockingMoveIndexInLine;
		
		// horizontal
		for (int y = 0; y < Board.SIZE; y++) {
			blockingMoveIndexInLine = this.getEmptyCellIndexInOpponentDoublesLine(board.getCellState(0, y), board.getCellState(1, y), board.getCellState(2, y));
			if (blockingMoveIndexInLine != -1) {
				return new Move(blockingMoveIndexInLine, y, this.getPlayerSymbol());
			}
		}
		
		// vertical
		for (int x = 0; x < Board.SIZE; x++) {
			blockingMoveIndexInLine = this.getEmptyCellIndexInOpponentDoublesLine(board.getCellState(x, 0), board.getCellState(x, 1), board.getCellState(x, 2));
			if (blockingMoveIndexInLine != -1) {
				return new Move(x, blockingMoveIndexInLine, this.getPlayerSymbol());
			}
		}
		
		// diagonal
		blockingMoveIndexInLine = this.getEmptyCellIndexInOpponentDoublesLine(board.getCellState(0, 0), board.getCellState(1, 1), board.getCellState(2, 2));
		if (blockingMoveIndexInLine != -1) {
			return new Move(blockingMoveIndexInLine, blockingMoveIndexInLine, this.getPlayerSymbol());
		}
		
		blockingMoveIndexInLine = this.getEmptyCellIndexInOpponentDoublesLine(board.getCellState(2, 0), board.getCellState(1, 1), board.getCellState(0, 2));
		if (blockingMoveIndexInLine != -1) {
			return new Move(2 - blockingMoveIndexInLine, blockingMoveIndexInLine, this.getPlayerSymbol());
		}
		
		return null;
	}
	
	private int getEmptyCellIndexInOpponentDoublesLine(CellState cellState0, CellState cellState1, CellState cellState2) {
		int emptyCellIndexInOpponentDoublesLine = -1;
		CellState opponentSymbol = Objects.requireNonNull(this.getPlayerSymbol().getInverse());
		
		if (opponentSymbol.equals(cellState0, cellState1) && cellState2.equals(CellState.EMPTY)) {
			emptyCellIndexInOpponentDoublesLine = 2;
		}
		
		if (opponentSymbol.equals(cellState0, cellState2) && cellState1.equals(CellState.EMPTY)) {
			emptyCellIndexInOpponentDoublesLine = 1;
		}
		
		if (opponentSymbol.equals(cellState1, cellState2) && cellState0.equals(CellState.EMPTY)) {
			emptyCellIndexInOpponentDoublesLine = 0;
		}
		
		return emptyCellIndexInOpponentDoublesLine;
	}
	
	
}
