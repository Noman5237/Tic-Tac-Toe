package game.tictactoe.views.gameview;

import game.tictactoe.views.ResizableView;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ScoreView implements ResizableView {
	
	private final HBox root;
	private final Label player1Score;
	private final Label player2Score;
	private final double HORIZONTAL_WEIGHT = 2;
	
	public ScoreView() {
		this.root = new HBox();
		this.player1Score = new Label("0");
		this.player2Score = new Label("0");
		
		this.player1Score.setPrefSize(200, 50);
		this.player2Score.setPrefSize(200, 50);
		
		this.player1Score.setAlignment(Pos.CENTER);
		this.player2Score.setAlignment(Pos.CENTER);
		
		this.root.getChildren().addAll(this.player1Score, this.player2Score);
	}
	
	@Override
	public void resize(double width, double height) {
		double unitWidth = width / this.HORIZONTAL_WEIGHT;
		this.player1Score.setPrefSize(unitWidth, height);
		this.player2Score.setPrefSize(unitWidth, height);
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
	
	public Label getPlayer1Score() {
		return this.player1Score;
	}
	
	public Label getPlayer2Score() {
		return this.player2Score;
	}
}
