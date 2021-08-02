package game.tictactoe.views.gameview;

import game.tictactoe.players.classic.UIPlayer;
import game.tictactoe.players.classic.ai.RandomAIPlayer;
import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class GameView implements ResizableView {
	
	private final VBox root;
	private final PlayerChoiceView playerChoiceView;
	private final ScoreView scoreView;
	private final BoardView boardView;
	private final ResetRestartView resetRestartView;
	
	public GameView(double width, double height) {
		this.root = new VBox();
		this.playerChoiceView = new PlayerChoiceView(UIPlayer.class, RandomAIPlayer.class);
		this.scoreView = new ScoreView();
		this.boardView = new BoardView(width, height);
		this.resetRestartView = new ResetRestartView();
		
		root.getChildren().addAll(
				playerChoiceView.getRoot(),
				scoreView.getRoot(),
				boardView.getRoot(),
				resetRestartView.getRoot()
		);
	}
	
	@Override
	public void resize(double width, double height) {
//		boardView.resize(width, height);
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
	
	public PlayerChoiceView getPlayerChoiceView() {
		return playerChoiceView;
	}
	
	public ScoreView getScoreView() {
		return scoreView;
	}
	
	public BoardView getBoardView() {
		return boardView;
	}
	
	public ResetRestartView getResetRestartView() {
		return resetRestartView;
	}
}
