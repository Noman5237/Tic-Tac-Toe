package game.tictactoe.managers;

import game.tictactoe.activities.GameActivity;
import game.tictactoe.models.Board;
import game.tictactoe.models.Move;
import game.tictactoe.models.Round;
import game.tictactoe.players.Player;
import game.tictactoe.states.RoundState;

public class GameManager {
	
	private static GameManager instance;
	
	private Player player1;
	private Player player2;
	private int player1Score;
	private int player2Score;
	private Round currentRound;
	private Player lastRoundWinner;
	private GameActivity gameActivity;
	private final ApplicationManager applicationManager;
	
	private GameManager() {
		this.player1Score = 0;
		this.player2Score = 0;
		
		this.applicationManager = ApplicationManager.getInstance();
		this.setupListeners();
	}
	
	private void setupListeners() {
		this.applicationManager.getApplicationConfiguration().addListener((observable, oldValue, newValue) -> this.gameActivity.getView().getBoardView().draw(this.currentRound.getBoard()));
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
		this.currentRound = new Round(new Board(), this.player1, this.player2);
		this.updateBoardView();
		this.currentRound.setCurrentPlayer(this.lastRoundWinner);
		this.currentRound.promptCurrentPlayer();
	}
	
	public void reset() {
		this.lastRoundWinner = this.player1;
		this.player1Score = 0;
		this.player2Score = 0;
		this.gameActivity.updatePlayer1Score(this.player1Score);
		this.gameActivity.updatePlayer2Score(this.player2Score);
		this.restart();
	}
	
	public void onRoundEnd() {
		RoundState roundStatus = this.currentRound.getRoundStatus();
		if (roundStatus == RoundState.X_WINS) {
			++this.player1Score;
			this.gameActivity.updatePlayer1Score(this.player1Score);
			this.lastRoundWinner = this.player1;
		} else if (roundStatus == RoundState.O_WINS) {
			++this.player2Score;
			this.gameActivity.updatePlayer2Score(this.player2Score);
			this.lastRoundWinner = this.player2;
		}
	}
	
	public void updateBoardView() {
		Board currentBoard = this.currentRound.getBoard();
		this.gameActivity.getView().getBoardView().draw(currentBoard);
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
		this.reset();
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
		this.reset();
	}
	
	public void setNextMove(Move move) {
		this.currentRound.setNextMove(move);
	}
}
