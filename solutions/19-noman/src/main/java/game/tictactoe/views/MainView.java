package game.tictactoe.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainView implements View {
	
	private final VBox root;
	private final Button playButton;
	private final Button optionsButton;
	private final Button aboutButton;
	
	private final int HORIZONTAL_WEIGHT = 2;
	private final int VERTICAL_WEIGHT = 6;
	private final Insets BUTTON_MARGINS =
			new Insets(this.VERTICAL_WEIGHT * 1.5,
					this.HORIZONTAL_WEIGHT,
					this.VERTICAL_WEIGHT * 1.5,
					this.HORIZONTAL_WEIGHT);
	
	public MainView(double width, double height) {
		this.playButton = new Button("play game".toUpperCase());
		this.optionsButton = new Button("options".toUpperCase());
		this.aboutButton = new Button("about".toUpperCase());
		this.root = new VBox();
		
		this.setupContainer();
		this.root.setPrefSize(width, height);
		this.setupButtonMargins();
	}
	
	private void setupContainer() {
		this.root.getChildren().addAll(this.playButton, this.optionsButton, this.aboutButton);
		this.root.setAlignment(Pos.CENTER);
	}
	
	private void setupButtonMargins() {
		VBox.setMargin(this.playButton, this.BUTTON_MARGINS);
		VBox.setMargin(this.optionsButton, this.BUTTON_MARGINS);
		VBox.setMargin(this.aboutButton, this.BUTTON_MARGINS);
	}
	
	@Override
	public void resize(double width, double height) {
		this.root.resize(width, height);
		this.resizeButtons(width, height);
	}
	
	private void resizeButtons(double width, double height) {
		this.playButton.setPrefSize(width / this.HORIZONTAL_WEIGHT, height / this.VERTICAL_WEIGHT);
		this.optionsButton.setPrefSize(width / this.HORIZONTAL_WEIGHT, height / this.VERTICAL_WEIGHT);
		this.aboutButton.setPrefSize(width / this.HORIZONTAL_WEIGHT, height / this.VERTICAL_WEIGHT);
		
		this.playButton.setFont(Font.font(height / (this.VERTICAL_WEIGHT * this.VERTICAL_WEIGHT)));
		this.optionsButton.setFont(Font.font(height / (this.VERTICAL_WEIGHT * this.VERTICAL_WEIGHT)));
		this.aboutButton.setFont(Font.font(height / (this.VERTICAL_WEIGHT * this.VERTICAL_WEIGHT)));
	}
	
	@Override
	public Parent getRoot() {
		return this.root;
	}
	
	public Button getPlayButton() {
		return this.playButton;
	}
	
	public Button getOptionsButton() {
		return this.optionsButton;
	}
	
	public Button getAboutButton() {
		return this.aboutButton;
	}
}
