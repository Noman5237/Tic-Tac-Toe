package game.tictactoe.managers;

import game.tictactoe.activities.GameActivity;
import game.tictactoe.models.Board;
import game.tictactoe.models.Move;
import game.tictactoe.models.states.CellState;
import game.tictactoe.models.states.RoundState;
import game.tictactoe.players.classic.Player;

public class GameManager {
	
	private static GameManager instance;
	
	private Board board;
	private Player player1;
	private Player player2;
	private int player1Score;
	private int player2Score;
	private Player currentPlayer;
	private Player lastRoundWinnerPlayer;
	private CellState cellState;
	private GameActivity gameActivity;
	
	private GameManager() {
		player1Score = 0;
		player2Score = 0;
		
		this.gameActivity = (GameActivity) ApplicationManager.getInstance().getCurrentActivity();
		gameActivity.getView().getBoardView().draw(new Board());
	}
	
	public static GameManager getInstance() {
		if (GameManager.instance == null) {
			GameManager.instance = new GameManager();
		}
		return GameManager.instance;
	}
	
	public void start() {
		if (player1 != null && player2 != null) {
			this.reset();
		} else {
			gameActivity.getView().getBoardView().draw(new Board());
		}
	}
	
	public void restart() {
		this.board = new Board();
		this.currentPlayer = this.lastRoundWinnerPlayer;
		updateBoardViewNPromptCurrentPlayerForNextMoveIfRoundRunning();
	}
	
	public void reset() {
		this.lastRoundWinnerPlayer = player1;
		this.player1Score = 0;
		this.player2Score = 0;
		gameActivity.updatePlayer1Score(player1Score);
		gameActivity.updatePlayer2Score(player2Score);
		restart();
	}
	
	private void updateBoardViewNPromptCurrentPlayerForNextMoveIfRoundRunning() {
		Board currentBoard = this.getCurrentBoard();
		gameActivity.getView().getBoardView().draw(currentBoard);
		RoundState roundStatus = this.getRoundStatus();
		if (roundStatus == RoundState.RUNNING) {
			this.currentPlayer.promptForNextMove(currentBoard);
		} else {
			if (roundStatus == RoundState.X_WINS) {
				++player1Score;
				gameActivity.updatePlayer1Score(player1Score);
			} else {
				++player2Score;
				gameActivity.updatePlayer2Score(player2Score);
			}
		}
	}
	
	private RoundState getRoundStatus() {
		// vertical
		for (int x = 0; x < Board.SIZE; x++) {
			cellState = this.board.getCellState(x, 0);
			if (cellState.equals(this.board.getCellState(x, 1), this.board.getCellState(x, 2))) {
				if (cellState != CellState.EMPTY) {
					if (cellState == CellState.X) {
						return RoundState.X_WINS;
					} else {
						return RoundState.O_WINS;
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
		
		int emptyCellCount = countEmptyCells(this.board);
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
	
	public Board getCurrentBoard() {
		return new Board(this.board);
	}
	
	public void setNextMove(Move move) {
		if (this.getRoundStatus() == RoundState.RUNNING) {
			this.board.setCellState(move.getX(), move.getY(), move.getCellState());
			if (this.currentPlayer == this.player1) {
				this.currentPlayer = this.player2;
			} else {
				this.currentPlayer = this.player1;
			}
			
			updateBoardViewNPromptCurrentPlayerForNextMoveIfRoundRunning();
		}
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
		this.start();
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
		this.start();
	}
	
}
