package game.tictactoe.manager;

import game.tictactoe.controller.player.UIPlayer;
import game.tictactoe.controller.player.ai.RandomAIPlayer;
import game.tictactoe.view.BoardView;
import game.tictactoe.view.PlayerChoiceView;
import game.tictactoe.view.ResetRestartView;
import game.tictactoe.view.ScoreView;
import javafx.scene.layout.VBox;

public class UIManager extends VBox {
	
	private static UIManager instance;
	
	private final BoardView boardView;
	private PlayerChoiceView playerChoiceView;
	private ResetRestartView resetRestartView;
	private ScoreView scoreView;
	
	private UIManager() {
		super();
		setPrefSize(400, 500);
		
		playerChoiceView = new PlayerChoiceView(UIPlayer.class, RandomAIPlayer.class);
		boardView = new BoardView(400, 400);
		resetRestartView = new ResetRestartView();
		scoreView = new ScoreView();

//		bindBoundProperties();
		
		super.getChildren().addAll(playerChoiceView, scoreView, boardView, resetRestartView);
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
	
	public ScoreView getScoreView() {
		return scoreView;
	}
	
	@Override
	public boolean isResizable() {
		return true;
	}
	
}
