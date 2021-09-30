package game.tictactoe.views.gameview;

import game.tictactoe.managers.ApplicationManager;
import game.tictactoe.models.Board;
import game.tictactoe.models.Theme;
import game.tictactoe.states.CellState;
import game.tictactoe.views.ResizableView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class BoardView implements ResizableView {
	
	private final Theme applicationTheme;
	private final Canvas canvas;
	private final GraphicsContext ctx;
	private final Timeline timeline;
	
	private Affine affine;
	
	public BoardView(double width, double height) {
		this.applicationTheme = ApplicationManager.getInstance().getApplicationConfiguration().getTheme();
		this.canvas = new Canvas(width, height);
		
		// graphics context
		this.ctx = this.canvas.getGraphicsContext2D();
		
		this.resize(width, height);
		this.timeline = new Timeline();
		this.timeline.setCycleCount(Timeline.INDEFINITE);
		this.draw(new Board());
	}
	
	public void draw(Board board) {
		this.timeline.getKeyFrames().clear();
		this.timeline.getKeyFrames().add(new KeyFrame(Duration.millis(10), event -> {
			this.drawBackground();
			for (int y = 0; y < Board.SIZE; y++) {
				for (int x = 0; x < Board.SIZE; x++) {
					CellState cellState = board.getCellState(x, y);
					if (cellState == CellState.X) {
						this.drawX(x, y);
					} else if (cellState == CellState.O) {
						this.drawO(x, y);
					}
				}
			}
		}));
		this.timeline.playFromStart();
	}
	
	private void drawX(double x, double y) {
		this.ctx.drawImage(this.applicationTheme.getX(), x, y, 1, 1);
	}
	
	private void drawO(double x, double y) {
		this.ctx.drawImage(this.applicationTheme.getO(), x, y, 1, 1);
	}
	
	public void drawBackground() {
		this.ctx.drawImage(this.applicationTheme.getBoard(), 0, 0, Board.SIZE, Board.SIZE);
	}
	
	@Override
	public void resize(double width, double height) {
		this.canvas.setWidth(width);
		this.canvas.setHeight(height);
		
		// transformation scale
		this.affine = new Affine(new Scale(width / ((double) Board.SIZE), height / ((double) Board.SIZE)));
		this.ctx.setTransform(this.affine);
	}
	
	@Override
	public Node getRoot() {
		return this.canvas;
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public Affine getAffine() {
		return this.affine;
	}
	
}
