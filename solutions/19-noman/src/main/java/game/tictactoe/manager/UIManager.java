package game.tictactoe.manager;

import game.tictactoe.view.BoardView;
import javafx.scene.layout.Pane;

public class UIManager extends Pane {
	
	private static UIManager instance;
	
	private final BoardView boardView;
	
	private UIManager() {
		super();
		setPrefSize(400, 400);
		
		boardView = new BoardView(super.getWidth(), super.getHeight());
		boardView.widthProperty().bind(this.widthProperty());
		boardView.heightProperty().bind(this.heightProperty());
		super.getChildren().addAll(boardView);
	}
	
	public static UIManager getInstance() {
		if (instance == null) {
			instance = new UIManager();
		}
		return instance;
	}
	
	@Override
	public void resize(double width, double height) {
		super.resize(width, height);
		boardView.resize(width, height);
		boardView.draw(GameManager.getInstance().getCurrentBoard());
	}
	
	public BoardView getBoardView() {
		return boardView;
	}
	
	@Override
	public boolean isResizable() {
		return true;
	}
	
}
