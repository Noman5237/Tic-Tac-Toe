package game.tictactoe.views.gameview;

import game.tictactoe.players.Players;
import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class PlayerChoiceView implements ResizableView {
	
	private final HBox root;
	
	private final ComboBox<Players> player1Choices;
	private final ComboBox<Players> player2Choices;
	
	private final int HORIZONTAL_WEIGHT = 2;
	
	public PlayerChoiceView() {
		this.root = new HBox();
		this.player1Choices = new ComboBox<>();
		this.player2Choices = new ComboBox<>();
		
		this.player1Choices.getItems().addAll(Players.values());
		this.player2Choices.getItems().addAll(Players.values());
		
		this.root.getChildren().addAll(this.player1Choices, this.player2Choices);
	}
	
	@Override
	public void resize(double width, double height) {
		double unitWidth = width / this.HORIZONTAL_WEIGHT;
		this.player1Choices.setPrefSize(unitWidth, height);
		this.player2Choices.setPrefSize(unitWidth, height);
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
	
	public ComboBox<Players> getPlayer1Choices() {
		return this.player1Choices;
	}
	
	public ComboBox<Players> getPlayer2Choices() {
		return this.player2Choices;
	}
}
