package game.tictactoe.views.gameview;

import game.tictactoe.views.ResizableView;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ScoreView implements ResizableView {
	
	private final HBox root;
	private final Label player1Score;
	private final Label player2Score;
	
	public ScoreView() {
		this.root = new HBox();
		player1Score = new Label("0");
		player2Score = new Label("0");
		
		this.player1Score.setPrefSize(200, 50);
		this.player2Score.setPrefSize(200, 50);
		
		this.player1Score.setFont(new Font("Arial", 24));
		this.player2Score.setFont(new Font("Arial", 24));
		this.player1Score.setAlignment(Pos.CENTER);
		this.player2Score.setAlignment(Pos.CENTER);
		
		this.root.getChildren().addAll(player1Score, player2Score);
	}
	
	@Override
	public void resize(double width, double height) {
	
	}
	
	@Override
	public Node getRoot() {
		return root;
	}
	
	public Label getPlayer1Score() {
		return player1Score;
	}
	
	public Label getPlayer2Score() {
		return player2Score;
	}
}
