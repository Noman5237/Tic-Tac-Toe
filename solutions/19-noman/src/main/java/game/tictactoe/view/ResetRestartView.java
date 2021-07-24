package game.tictactoe.view;

import game.tictactoe.manager.GameManager;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResetRestartView extends HBox {
	
	private final Button resetButton;
	private final Button restartButton;
	
	public ResetRestartView() {
		this.resetButton = new Button("RESET SCORE");
		this.restartButton = new Button("RESTART GAME");
		
		this.resetButton.setPrefSize(200, 100);
		this.restartButton.setPrefSize(200, 100);
		
		getChildren().addAll(this.resetButton, this.restartButton);
		
		this.setUpActions();
	}
	
	private void setUpActions() {
		this.resetButton.setOnAction(event -> GameManager.getInstance().reset());
		this.restartButton.setOnAction(event -> GameManager.getInstance().restart());
	}
}