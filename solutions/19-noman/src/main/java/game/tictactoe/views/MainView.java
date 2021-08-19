package game.tictactoe.views;

import game.tictactoe.managers.ApplicationManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainView implements ResizableView {
	
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
		this.root = new VBox();
		this.playButton = new Button("play game".toUpperCase());
		this.optionsButton = new Button("options".toUpperCase());
		this.aboutButton = new Button("about".toUpperCase());
		
		this.setupIds();
		this.setupRoot();
		this.setupMargins();
		this.root.setPrefSize(width, height);
	}
	
	public void setupIds() {
		this.root.setId("main-root-vbox");
		this.playButton.setId("main-play-button");
		this.optionsButton.setId("main-options-button");
		this.aboutButton.setId("main-about-button");
	}
	
	private void setupRoot() {
		this.root.getChildren().addAll(this.playButton, this.optionsButton, this.aboutButton);
		this.root.setAlignment(Pos.CENTER);
	}
	
	private void setupMargins() {
		VBox.setMargin(this.playButton, this.BUTTON_MARGINS);
		VBox.setMargin(this.optionsButton, this.BUTTON_MARGINS);
		VBox.setMargin(this.aboutButton, this.BUTTON_MARGINS);
	}
	
	@Override
	public void resize(double width, double height) {
		this.root.resize(width, height);
		double unitWidth = width / this.HORIZONTAL_WEIGHT;
		double unitHeight = height / this.VERTICAL_WEIGHT;
		this.playButton.setPrefSize(unitWidth, unitHeight);
		this.optionsButton.setPrefSize(unitWidth, unitHeight);
		this.aboutButton.setPrefSize(unitWidth, unitHeight);
		this.resizeFonts(ApplicationManager.getInstance().getApplicationConfiguration().getWindowScaleY());
	}
	
	private void resizeFonts(double scaleY) {
		// TODO: new font size = default font size * scaleY
	}
	
	@Override
	public Node getRoot() {
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
