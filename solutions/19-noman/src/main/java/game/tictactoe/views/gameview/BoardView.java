package game.tictactoe.views.gameview;

import game.tictactoe.models.Board;
import game.tictactoe.models.states.CellState;
import game.tictactoe.views.ResizableView;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;

public class BoardView implements ResizableView {
	
	private final Canvas canvas;
	private final GraphicsContext ctx;
	
	private static final double RADIUS = 0.25;
	private static final double LINE_WIDTH = RADIUS / 4.0;
	private static final double OFFSET = 0.25;
	
	private Affine affine;
	
	public BoardView(double width, double height) {
		this.canvas = new Canvas(width, height);
		
		// graphics context
		this.ctx = this.canvas.getGraphicsContext2D();
		
		this.ctx.setLineWidth(LINE_WIDTH);
		
		// TODO: Themes
		this.ctx.setFill(Color.LIGHTGRAY);
		this.ctx.setStroke(Color.BLACK);
		
		this.reset();
		this.resize(width, height);
	}
	
	public void draw(Board board) {
		this.reset();
		for (int y = 0; y < Board.SIZE; y++) {
			for (int x = 0; x < Board.SIZE; x++) {
				CellState cellState = board.getCellState(x, y);
				if (cellState == CellState.X) {
					this.drawX(x + OFFSET, y + OFFSET);
				} else if (cellState == CellState.O) {
					this.drawO(x + OFFSET, y + OFFSET);
				}
			}
		}
	}
	
	private void drawX(double x, double y) {
		this.ctx.strokeLine(x, y, x + BoardView.RADIUS * 2, y + BoardView.RADIUS * 2);
		this.ctx.strokeLine(x + BoardView.RADIUS * 2, y, x, y + BoardView.RADIUS * 2);
	}
	
	private void drawO(double x, double y) {
		this.ctx.strokeOval(x, y, BoardView.RADIUS * 2, BoardView.RADIUS * 2);
	}
	
	public void reset() {
		this.ctx.fillRect(0, 0, Board.SIZE, Board.SIZE);
		
		// Vertical Lines
		this.ctx.strokeLine(1, 0, 1, Board.SIZE);
		this.ctx.strokeLine(2, 0, 2, Board.SIZE);
		
		// Horizontal Lines
		this.ctx.strokeLine(0, 1, Board.SIZE, 1);
		this.ctx.strokeLine(0, 2, Board.SIZE, 2);
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
