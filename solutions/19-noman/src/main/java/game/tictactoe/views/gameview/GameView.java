package game.tictactoe.views.gameview;

import game.tictactoe.players.classic.UIPlayer;
import game.tictactoe.players.classic.ai.RandomAIPlayer;
import game.tictactoe.views.HeaderView;
import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class GameView implements ResizableView {
	
	private final VBox root;
	private final HeaderView headerView;
	private final PlayerChoiceView playerChoiceView;
	private final ScoreView scoreView;
	private final BoardView boardView;
	private final ResetRestartView resetRestartView;
	
	private final int VERTICAL_WEIGHT = 10;
	
	public GameView(double width, double height) {
		this.root = new VBox();
		headerView = new HeaderView("Tic-Tac-Toe-Classic");
		this.playerChoiceView = new PlayerChoiceView(UIPlayer.class, RandomAIPlayer.class);
		this.scoreView = new ScoreView();
		this.boardView = new BoardView(width, height);
		this.resetRestartView = new ResetRestartView();
		
		root.getChildren().addAll(
				headerView.getRoot(),
				playerChoiceView.getRoot(),
				scoreView.getRoot(),
				boardView.getRoot(),
				resetRestartView.getRoot()
		);
		
		this.root.setPrefSize(width, height);
	}
	
	@Override
	public void resize(double width, double height) {
		this.root.resize(width, height);
		double unitHeight = height / VERTICAL_WEIGHT;
		headerView.resize(width, unitHeight);
		playerChoiceView.resize(width, unitHeight);
		scoreView.resize(width, unitHeight);
		boardView.resize(width, unitHeight * 6);
		resetRestartView.resize(width, unitHeight);
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
