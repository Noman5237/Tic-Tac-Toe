package game.tictactoe.models;

import game.tictactoe.managers.GameManager;
import game.tictactoe.players.Player;
import game.tictactoe.states.CellState;
import game.tictactoe.states.RoundState;

public class Round {
	
	private final Board board;
	private final Player player1;
	private final Player player2;
	private Player currentPlayer;
	
	public Round(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void setNextMove(Move move) {
		if (this.getRoundStatus() == RoundState.RUNNING) {
			this.board.setCellState(move.getX(), move.getY(), move.getCellState());
			if (this.currentPlayer == this.player1) {
				this.setCurrentPlayer(this.player2);
			} else {
				this.setCurrentPlayer(this.player1);
			}
			
			GameManager.getInstance().updateBoardView();
			this.promptCurrentPlayer();
		}
	}
	
	public void promptCurrentPlayer() {
		RoundState roundStatus = this.getRoundStatus();
		if (roundStatus == RoundState.RUNNING) {
			this.currentPlayer.promptForNextMove(this.getBoard());
		} else {
			GameManager.getInstance().onRoundEnd();
		}
	}
	
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public Board getBoard() {
		return new Board(this.board);
	}
	
	public RoundState getRoundStatus() {
		CellState cellState;
		// vertical
		for (int x = 0; x < Board.SIZE; x++) {
			cellState = this.board.getCellState(x, 0);
			if (cellState.equals(this.board.getCellState(x, 1), this.board.getCellState(x, 2))) {
				if (cellState != CellState.EMPTY) {
					if (cellState == CellState.X) {
						return RoundState.X_WINS;
					} else if (cellState == CellState.O) {
						return RoundState.O_WINS;
					} else {
						return RoundState.DRAW;
					}
				}
			}
		}
		
		// horizontal
		for (int y = 0; y < Board.SIZE; y++) {
			cellState = this.board.getCellState(0, y);
			if (cellState.equals(this.board.getCellState(1, y), this.board.getCellState(2, y))) {
				if (cellState != CellState.EMPTY) {
					if (cellState == CellState.X) {
						return RoundState.X_WINS;
					} else {
						return RoundState.O_WINS;
					}
				}
			}
		}
		
		// diagonal
		cellState = this.board.getCellState(0, 0);
		if (cellState.equals(this.board.getCellState(1, 1), this.board.getCellState(2, 2))) {
			if (cellState != CellState.EMPTY) {
				if (cellState == CellState.X) {
					return RoundState.X_WINS;
				} else {
					return RoundState.O_WINS;
				}
			}
		}
		
		cellState = this.board.getCellState(2, 0);
		if (cellState.equals(this.board.getCellState(1, 1), this.board.getCellState(0, 2))) {
			if (cellState != CellState.EMPTY) {
				if (cellState == CellState.X) {
					return RoundState.X_WINS;
				} else {
					return RoundState.O_WINS;
				}
			}
		}
		
		int emptyCellCount = this.countEmptyCells(this.board);
		if (emptyCellCount > 0) {
			return RoundState.RUNNING;
		}
		
		return RoundState.DRAW;
	}
	
	private int countEmptyCells(Board board) {
		int count = 0;
		for (int y = 0; y < Board.SIZE; y++) {
			for (int x = 0; x < Board.SIZE; x++) {
				if (board.getCellState(x, y) == CellState.EMPTY) {
					++count;
				}
			}
		}
		
		return count;
	}
}
