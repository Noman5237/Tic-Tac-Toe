package game.tictactoe.views.gameview;

import game.tictactoe.players.classic.Player;
import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class PlayerChoiceView implements ResizableView {
	
	private final HBox root;
	
	private final ComboBox<Class<? extends Player>> player1Choices;
	private final ComboBox<Class<? extends Player>> player2Choices;
	
	private final int HORIZONTAL_WEIGHT = 2;
	
	@SafeVarargs
	public PlayerChoiceView(Class<? extends Player>... playerTypes) {
		this.root = new HBox();
		this.player1Choices = new ComboBox<>();
		this.player2Choices = new ComboBox<>();
		
		this.player1Choices.getItems().addAll(playerTypes);
		this.player2Choices.getItems().addAll(playerTypes);
		
		this.root.getChildren().addAll(player1Choices, player2Choices);
	}
	
	@Override
	public void resize(double width, double height) {
		double unitWidth = width / HORIZONTAL_WEIGHT;
		this.player1Choices.setPrefSize(unitWidth, height);
		this.player2Choices.setPrefSize(unitWidth, height);
	}
	
	@Override
	public Node getRoot() {
		return root;
	}
	
	public ComboBox<Class<? extends Player>> getPlayer1Choices() {
		return player1Choices;
	}
	
	public ComboBox<Class<? extends Player>> getPlayer2Choices() {
		return player2Choices;
	}
}
