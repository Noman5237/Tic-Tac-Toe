package game.tictactoe.views;

import game.tictactoe.managers.GameManager;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResetRestartView extends HBox {
	
	private final Button resetButton;
	private final Button restartButton;
	
	public ResetRestartView() {
		this.resetButton = new Button("RESET SCORE");
		this.restartButton = new Button("RESTART GAME");
		
		this.resetButton.setPrefSize(200, 50);
		this.restartButton.setPrefSize(200, 50);
		
		getChildren().addAll(this.resetButton, this.restartButton);
		
		this.setUpActions();
	}
	
	private void setUpActions() {
		this.resetButton.setOnAction(event -> GameManager.getInstance().reset());
		this.restartButton.setOnAction(event -> GameManager.getInstance().restart());
	}
}
