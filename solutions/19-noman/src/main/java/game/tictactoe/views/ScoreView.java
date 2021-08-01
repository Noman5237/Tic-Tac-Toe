package game.tictactoe.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ScoreView extends HBox {
	
	private Label player1Score;
	private Label player2Score;
	
	public ScoreView() {
		player1Score = new Label("0");
		player2Score = new Label("0");
		
		this.player1Score.setPrefSize(200, 50);
		this.player2Score.setPrefSize(200, 50);
		
		this.player1Score.setFont(new Font("Arial", 24));
		this.player2Score.setFont(new Font("Arial", 24));
		this.player1Score.setAlignment(Pos.CENTER);
		this.player2Score.setAlignment(Pos.CENTER);
		
		super.getChildren().addAll(player1Score, player2Score);
	}
	
	public void updatePlayer1Score(int newScore) {
		player1Score.setText("" + newScore);
	}
	
	public void updatePlayer2Score(int newScore) {
		player2Score.setText("" + newScore);
	}
}
