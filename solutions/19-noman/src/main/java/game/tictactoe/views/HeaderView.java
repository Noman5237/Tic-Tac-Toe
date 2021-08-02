package game.tictactoe.views;

import game.tictactoe.managers.ApplicationManager;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HeaderView implements ResizableView {
	
	private HBox root;
	private Button goBackButton;
	private Label title;
	
	private final int HORIZONTAL_WEIGHT = 10;
	
	public HeaderView(String titleText) {
		this.root = new HBox();
		
		this.goBackButton = new Button("<");
		this.title = new Label(titleText);
		
		this.root.getChildren().addAll(goBackButton, title);
		this.setupGoBackListener();
	}
	
	private void setupGoBackListener() {
		this.goBackButton.setOnAction(event -> ApplicationManager.getInstance().destroyCurrentActivity());
	}
	
	@Override
	public void resize(double width, double height) {
		double unitWidth = width / HORIZONTAL_WEIGHT;
		this.goBackButton.setPrefSize(unitWidth, height);
		this.title.setPrefSize(unitWidth * 9, height);
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
}
