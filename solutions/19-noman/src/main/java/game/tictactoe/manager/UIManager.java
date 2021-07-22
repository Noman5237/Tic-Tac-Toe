package game.tictactoe.manager;

import game.tictactoe.model.Board;
import game.tictactoe.view.BoardView;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class UIManager {
	
	private static UIManager instance;
	
	private final BoardView boardView;
	
	private UIManager() {
		boardView = new BoardView(400, 400);
		boardView.draw(new Board());
	}
	
	public static UIManager getInstance() {
		if (instance == null) {
			instance = new UIManager();
		}
		return instance;
	}
	
	public BoardView getBoardView() {
		return boardView;
	}
	
	public Parent getSceneRoot() {
		Pane pane;
		pane = new Pane(boardView);
		return pane;
	}
	
}
