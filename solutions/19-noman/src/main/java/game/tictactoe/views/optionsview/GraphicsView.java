package game.tictactoe.views.optionsview;

import game.tictactoe.views.ResizableView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

public class GraphicsView implements ResizableView {
	
	private final VBox root;
	private final ChoiceBox<String> themes;
	
	public GraphicsView() {
		this.root = new VBox();
		this.themes = new ChoiceBox<>();
		
		this.setupIds();
		this.setupRoot();
	}
	
	private void setupIds() {
	}
	
	private void setupRoot() {
		this.root.getChildren().addAll(this.themes);
	}
	
	@Override
	public void resize(double width, double height) {
	
	}
	
	@Override
	public VBox getRoot() {
		return this.root;
	}
	
	public ChoiceBox<String> getThemes() {
		return this.themes;
	}
}
