package game.tictactoe.manager;

import game.tictactoe.controller.player.Player;
import game.tictactoe.model.Board;
import game.tictactoe.model.Move;

public class GameManager {
	
	private static GameManager instance;
	
	private Board board;
	private Player player1;
	private Player player2;
	private int player1Score;
	private int player2Score;
	private Player currentPlayer;
	private Player lastRoundWinnerPlayer;
	
	private GameManager() {
		player1Score = 0;
		player2Score = 0;
	}
	
	public static GameManager getInstance() {
		if (GameManager.instance == null) {
			GameManager.instance = new GameManager();
		}
		return GameManager.instance;
	}
	
	public void start() {
		this.board = new Board();
		this.currentPlayer = this.player1;
		this.currentPlayer.promptForNextMove(this.getCurrentBoard());
	}
	
	public Board getCurrentBoard() {
		return new Board(this.board);
	}
	
	public void setNextMove(Move move) {
		this.board.setCellState(move.getX(), move.getY(), move.getCellState());
		if (this.currentPlayer == this.player1) {
			this.currentPlayer = this.player2;
		} else {
			this.currentPlayer = this.player1;
		}
		Board currentBoard = this.getCurrentBoard();
		UIManager.getInstance().getBoardView().draw(currentBoard);
		this.currentPlayer.promptForNextMove(currentBoard);
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
}
