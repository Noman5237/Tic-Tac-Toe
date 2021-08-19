package game.tictactoe.views.optionsview;

import game.tictactoe.views.HeaderView;
import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class OptionsView implements ResizableView {
	
	private final VBox root;
	private final HeaderView headerView;
	private final TabPane optionCategories;
	private final GraphicsView graphicsView;
	
	public OptionsView() {
		this.root = new VBox();
		this.headerView = new HeaderView("Options");
		this.graphicsView = new GraphicsView();
		this.optionCategories = new TabPane();
		
		this.setupIds();
		this.setupCategories();
		this.setupRoot();
	}
	
	private void setupIds() {
	}
	
	private void setupCategories() {
		Tab graphicsTab = new Tab("Graphics", graphicsView.getRoot());
		this.optionCategories.getTabs().addAll(graphicsTab);
		this.optionCategories.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
	}
	
	private void setupRoot() {
		this.root.getChildren().addAll(headerView.getRoot(), this.optionCategories);
	}
	
	@Override
	public void resize(double width, double height) {
	
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
	
	public GraphicsView getGraphicsView() {
		return graphicsView;
	}
}
