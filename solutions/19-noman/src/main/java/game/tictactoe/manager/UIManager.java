package game.tictactoe.manager;

import game.tictactoe.controller.player.UIPlayer;
import game.tictactoe.controller.player.ai.RandomAIPlayer;
import game.tictactoe.view.BoardView;
import game.tictactoe.view.PlayerChoiceView;
import game.tictactoe.view.ResetRestartView;
import javafx.scene.layout.VBox;

public class UIManager extends VBox {
	
	private static UIManager instance;
	
	private final BoardView boardView;
	private PlayerChoiceView playerChoiceView;
	private ResetRestartView resetRestartView;
	
	private UIManager() {
		super();
		setPrefSize(400, 460);
		
		playerChoiceView = new PlayerChoiceView(UIPlayer.class, RandomAIPlayer.class);
		boardView = new BoardView(400, 400);
		resetRestartView = new ResetRestartView();
		
//		bindBoundProperties();
		
		super.getChildren().addAll(playerChoiceView, boardView, resetRestartView);
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
//		boardView.resize(width, height);
//		boardView.draw(GameManager.getInstance().getCurrentBoard());
	}
	
	private void bindBoundProperties() {
		boardView.widthProperty().bind(this.widthProperty());
		boardView.heightProperty().bind(this.heightProperty());
	}
	
	public BoardView getBoardView() {
		return boardView;
	}
	
	@Override
	public boolean isResizable() {
		return true;
	}
	
}
