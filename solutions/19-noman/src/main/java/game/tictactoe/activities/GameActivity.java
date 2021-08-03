package game.tictactoe.activities;

import game.tictactoe.managers.ApplicationManager;
import game.tictactoe.managers.GameManager;
import game.tictactoe.models.Board;
import game.tictactoe.models.states.ApplicationConfiguration;
import game.tictactoe.models.states.CellState;
import game.tictactoe.players.classic.Player;
import game.tictactoe.views.gameview.GameView;
import javafx.scene.control.ComboBox;

import java.lang.reflect.InvocationTargetException;

public class GameActivity implements Activity {
	
	private GameView gameView;
	private final ApplicationConfiguration applicationConfiguration;
	
	public GameActivity() {
		this.applicationConfiguration = ApplicationManager.getInstance().getApplicationConfiguration();
		this.initializeView();
		this.setupListeners();
		this.setupOnAction();
		
		this.gameView.getBoardView().draw(new Board());
	}
	
	private void initializeView() {
		double windowWidth = this.applicationConfiguration.getWindowWidth();
		double windowHeight = this.applicationConfiguration.getWindowHeight();
		this.gameView = new GameView(windowWidth, windowHeight);
		this.gameView.resize(windowWidth, windowHeight);
	}
	
	private void setupListeners() {
		this.applicationConfiguration.addListener((observable, oldValue, newValue) -> this.gameView.resize(this.applicationConfiguration.getWindowWidth(), this.applicationConfiguration.getWindowHeight()));
	}
	
	private void setupOnAction() {
		this.setupPlayerChoiceOnAction();
		this.setUpResetRestartActions();
	}
	
	private void setupPlayerChoiceOnAction() {
		ComboBox<Class<? extends Player>> player1Choices = this.gameView.getPlayerChoiceView().getPlayer1Choices();
		player1Choices.setOnAction(event -> {
			Class<? extends Player> playerClass = player1Choices.getSelectionModel().getSelectedItem();
			GameManager.getInstance().setPlayer1(this.createPlayerInstance(playerClass, CellState.X));
		});
		
		ComboBox<Class<? extends Player>> player2Choices = this.gameView.getPlayerChoiceView().getPlayer2Choices();
		player2Choices.setOnAction(event -> {
			Class<? extends Player> playerClass = player2Choices.getSelectionModel().getSelectedItem();
			GameManager.getInstance().setPlayer2(this.createPlayerInstance(playerClass, CellState.O));
		});
	}
	
	private Player createPlayerInstance(Class<? extends Player> playerClass, CellState cellState) {
		try {
			return playerClass.getConstructor(CellState.class).newInstance(cellState);
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ignored) {
		}
		
		throw new RuntimeException("cannot update to the selected player type");
	}
	
	public void updatePlayer1Score(int newScore) {
		this.gameView.getScoreView().getPlayer1Score().setText("" + newScore);
	}
	
	public void updatePlayer2Score(int newScore) {
		this.gameView.getScoreView().getPlayer2Score().setText("" + newScore);
	}
	
	private void setUpResetRestartActions() {
		this.gameView.getResetRestartView().getResetButton().setOnAction(event -> GameManager.getInstance().reset());
		this.gameView.getResetRestartView().getRestartButton().setOnAction(event -> GameManager.getInstance().restart());
	}
	
	@Override
	public GameView getView() {
		return this.gameView;
	}
	
	@Override
	public void onDestroy() {
	
	}
}
