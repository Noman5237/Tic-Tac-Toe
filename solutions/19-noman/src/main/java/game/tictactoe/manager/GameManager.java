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
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}
	
	public void start() {
		board = new Board();
		currentPlayer = player1;
		currentPlayer.promptForNextMove(board.copy());
	}
	
	public void setNextMove(Move move) {
		board.setCellState(move.getX(), move.getY(), move.getCellState());
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		UIManager.getInstance().getBoardView().draw(board);
		currentPlayer.promptForNextMove(board.copy());
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
}
