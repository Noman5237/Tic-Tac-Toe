package game.tictactoe.views.gameview;

import game.tictactoe.managers.ApplicationManager;
import game.tictactoe.views.HeaderView;
import game.tictactoe.views.ResizableView;
import javafx.geometry.Insets;
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
	private final Insets MARGINS =
			new Insets(0,
					0,
					this.VERTICAL_WEIGHT * 1.5,
					0);
	
	public GameView(double width, double height) {
		this.root = new VBox();
		this.headerView = new HeaderView("Tic-Tac-Toe-Classic");
		this.playerChoiceView = new PlayerChoiceView();
		this.scoreView = new ScoreView();
		this.boardView = new BoardView(width, height);
		this.resetRestartView = new ResetRestartView();
		
		this.setupContainer(width, height);
	}
	
	private void setupContainer(double width, double height) {
		this.root.getChildren().addAll(
				this.headerView.getRoot(),
				this.playerChoiceView.getRoot(),
				this.scoreView.getRoot(),
				this.boardView.getRoot(),
				this.resetRestartView.getRoot()
		);
		
		this.root.setPrefSize(width, height);
	}
	
	@Override
	public void resize(double width, double height) {
		this.root.resize(width, height);
		double unitHeight = height / this.VERTICAL_WEIGHT;
		this.headerView.resize(width, unitHeight);
		this.playerChoiceView.resize(width, unitHeight);
		this.scoreView.resize(width, unitHeight);
		this.boardView.resize(width, unitHeight * 6);
		this.resetRestartView.resize(width, unitHeight);
		this.resizeFonts(ApplicationManager.getInstance().getApplicationConfiguration().getWindowScaleY());
	}
	
	private void resizeFonts(double scaleY) {
		// TODO: new font size = default font size * scaleY
	}
	
	@Override
	public Node getRoot() {
		return this.root;
	}
	
	public PlayerChoiceView getPlayerChoiceView() {
		return this.playerChoiceView;
	}
	
	public ScoreView getScoreView() {
		return this.scoreView;
	}
	
	public BoardView getBoardView() {
		return this.boardView;
	}
	
	public ResetRestartView getResetRestartView() {
		return this.resetRestartView;
	}
}
