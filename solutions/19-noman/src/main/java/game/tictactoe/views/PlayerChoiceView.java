package game.tictactoe.views;

import game.tictactoe.players.classic.Player;
import game.tictactoe.managers.GameManager;
import game.tictactoe.models.states.CellState;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.lang.reflect.InvocationTargetException;

public class PlayerChoiceView extends HBox {
	
	private final ComboBox<Class<? extends Player>> player1Choices;
	private final ComboBox<Class<? extends Player>> player2Choices;
	
	@SafeVarargs
	public PlayerChoiceView(Class<? extends Player>... playerTypes) {
		this.player1Choices = new ComboBox<>();
		this.player2Choices = new ComboBox<>();
		
		this.player1Choices.getItems().addAll(playerTypes);
		this.player2Choices.getItems().addAll(playerTypes);
		
		this.getChildren().addAll(player1Choices, player2Choices);
		
		this.player1Choices.setOnAction(event -> {
			Class<? extends Player> playerClass = player1Choices.getSelectionModel().getSelectedItem();
			GameManager.getInstance().setPlayer1(createPlayerInstance(playerClass, CellState.X));
		});
		
		this.player2Choices.setOnAction(event -> {
			Class<? extends Player> playerClass = player2Choices.getSelectionModel().getSelectedItem();
			GameManager.getInstance().setPlayer2(createPlayerInstance(playerClass, CellState.O));
		});
	}
	
	private Player createPlayerInstance(Class<? extends Player> playerClass, CellState cellState) {
		try {
			return playerClass.getConstructor(CellState.class).newInstance(cellState);
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ignored) {
		}
		
		throw new RuntimeException("cannot update to the selected player type");
	}
	
}
