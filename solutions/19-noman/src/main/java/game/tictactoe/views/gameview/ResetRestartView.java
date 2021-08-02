package game.tictactoe.views.gameview;

import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResetRestartView implements ResizableView {
	
	private final HBox root;
	private final Button resetButton;
	private final Button restartButton;
	private final double HORIZONTAL_WEIGHT = 2;
	
	public ResetRestartView() {
		this.root = new HBox();
		this.resetButton = new Button("RESET SCORE");
		this.restartButton = new Button("RESTART GAME");
		
		this.resetButton.setPrefSize(200, 50);
		this.restartButton.setPrefSize(200, 50);
		
		this.root.getChildren().addAll(this.resetButton, this.restartButton);
		
	}
	
	@Override
	public void resize(double width, double height) {
		double unitWidth = width / this.HORIZONTAL_WEIGHT;
		this.resetButton.setPrefSize(unitWidth, height);
		this.restartButton.setPrefSize(unitWidth, height);
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
	
	public Button getResetButton() {
		return this.resetButton;
	}
	
	public Button getRestartButton() {
		return this.restartButton;
	}
}
