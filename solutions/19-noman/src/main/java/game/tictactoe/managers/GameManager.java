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
	private final ApplicationManager applicationManager;
	
	private GameManager() {
		this.player1Score = 0;
		this.player2Score = 0;
		
		this.applicationManager = ApplicationManager.getInstance();
		this.setupListeners();
	}
	
	private void setupListeners() {
		this.applicationManager.getApplicationConfiguration().addListener((observable, oldValue, newValue) -> this.gameActivity.getView().getBoardView().draw(this.getCurrentBoard()));
	}
	
	public static GameManager getInstance() {
		if (GameManager.instance == null) {
			GameManager.instance = new GameManager();
		}
		return GameManager.instance;
	}
	
	public void start() {
		this.gameActivity = (GameActivity) this.applicationManager.getCurrentActivity();
		
		this.gameActivity.getView().getPlayerChoiceView().getPlayer1Choices().getSelectionModel().selectFirst();
		this.gameActivity.getView().getPlayerChoiceView().getPlayer2Choices().getSelectionModel().selectFirst();
		this.gameActivity.getView().getPlayerChoiceView().getPlayer1Choices().getOnAction().handle(null);
		this.gameActivity.getView().getPlayerChoiceView().getPlayer2Choices().getOnAction().handle(null);
		
		this.reset();
	}
	
	public void restart() {
		this.board = new Board();
		this.currentPlayer = this.lastRoundWinnerPlayer;
		this.updateBoardViewNPromptCurrentPlayerForNextMoveIfRoundRunning();
	}
	
	public void reset() {
		this.lastRoundWinnerPlayer = this.player1;
		this.player1Score = 0;
		this.player2Score = 0;
		this.gameActivity.updatePlayer1Score(this.player1Score);
		this.gameActivity.updatePlayer2Score(this.player2Score);
		this.restart();
	}
	
	private void updateBoardViewNPromptCurrentPlayerForNextMoveIfRoundRunning() {
		Board currentBoard = this.getCurrentBoard();
		this.gameActivity.getView().getBoardView().draw(currentBoard);
		RoundState roundStatus = this.getRoundStatus();
		if (roundStatus == RoundState.RUNNING) {
			this.currentPlayer.promptForNextMove(currentBoard);
		} else {
			if (roundStatus == RoundState.X_WINS) {
				++this.player1Score;
				this.gameActivity.updatePlayer1Score(this.player1Score);
			} else if (roundStatus == RoundState.O_WINS) {
				++this.player2Score;
				this.gameActivity.updatePlayer2Score(this.player2Score);
			}
		}
	}
	
	private RoundState getRoundStatus() {
		// vertical
		for (int x = 0; x < Board.SIZE; x++) {
			this.cellState = this.board.getCellState(x, 0);
			if (this.cellState.equals(this.board.getCellState(x, 1), this.board.getCellState(x, 2))) {
				if (this.cellState != CellState.EMPTY) {
					if (this.cellState == CellState.X) {
						return RoundState.X_WINS;
					} else if (this.cellState == CellState.O) {
						return RoundState.O_WINS;
					} else {
						return RoundState.DRAW;
					}
				}
			}
		}
		
		// horizontal
		for (int y = 0; y < Board.SIZE; y++) {
			this.cellState = this.board.getCellState(0, y);
			if (this.cellState.equals(this.board.getCellState(1, y), this.board.getCellState(2, y))) {
				if (this.cellState != CellState.EMPTY) {
					if (this.cellState == CellState.X) {
						return RoundState.X_WINS;
					} else {
						return RoundState.O_WINS;
					}
				}
			}
		}
		
		// diagonal
		this.cellState = this.board.getCellState(0, 0);
		if (this.cellState.equals(this.board.getCellState(1, 1), this.board.getCellState(2, 2))) {
			if (this.cellState != CellState.EMPTY) {
				if (this.cellState == CellState.X) {
					return RoundState.X_WINS;
				} else {
					return RoundState.O_WINS;
				}
			}
		}
		
		this.cellState = this.board.getCellState(2, 0);
		if (this.cellState.equals(this.board.getCellState(1, 1), this.board.getCellState(0, 2))) {
			if (this.cellState != CellState.EMPTY) {
				if (this.cellState == CellState.X) {
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
			
			this.updateBoardViewNPromptCurrentPlayerForNextMoveIfRoundRunning();
		}
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
		this.reset();
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
		this.reset();
	}
	
}
