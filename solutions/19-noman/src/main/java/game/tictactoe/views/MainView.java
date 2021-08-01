package game.tictactoe.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainView extends VBox {
	
	private final Button playButton;
	private final Button optionsButton;
	private final Button aboutButton;
	
	private final int HORIZONTAL_WEIGHT = 2;
	private final int VERTICAL_WEIGHT = 6;
	private final Insets BUTTON_MARGINS =
			new Insets(VERTICAL_WEIGHT * 1.5,
					HORIZONTAL_WEIGHT,
					VERTICAL_WEIGHT * 1.5,
					HORIZONTAL_WEIGHT);
	
	public MainView(int width, int height) {
		this.playButton = new Button("play game".toUpperCase());
		this.optionsButton = new Button("options".toUpperCase());
		this.aboutButton = new Button("about".toUpperCase());
		
		this.setupContainer();
		super.setPrefSize(width, height);
		this.setupButtonMargins();
	}
	
	private void setupContainer() {
		super.getChildren().addAll(this.playButton, this.optionsButton, this.aboutButton);
		super.setAlignment(Pos.CENTER);
	}
	
	private void setupButtonMargins() {
		VBox.setMargin(this.playButton, this.BUTTON_MARGINS);
		VBox.setMargin(this.optionsButton, this.BUTTON_MARGINS);
		VBox.setMargin(this.aboutButton, this.BUTTON_MARGINS);
	}
	
	@Override
	public void resize(double width, double height) {
		super.resize(width, height);
		this.resizeButtons(width, height);
	}
	
	private void resizeButtons(double width, double height) {
		this.playButton.setPrefSize(width / HORIZONTAL_WEIGHT, height / VERTICAL_WEIGHT);
		this.optionsButton.setPrefSize(width / HORIZONTAL_WEIGHT, height / VERTICAL_WEIGHT);
		this.aboutButton.setPrefSize(width / HORIZONTAL_WEIGHT, height / VERTICAL_WEIGHT);
		
		this.playButton.setFont(Font.font(height / (VERTICAL_WEIGHT * VERTICAL_WEIGHT)));
		this.optionsButton.setFont(Font.font(height / (VERTICAL_WEIGHT * VERTICAL_WEIGHT)));
		this.aboutButton.setFont(Font.font(height / (VERTICAL_WEIGHT * VERTICAL_WEIGHT)));
	}
}
