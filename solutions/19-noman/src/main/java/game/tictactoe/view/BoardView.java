package game.tictactoe.view;

import game.tictactoe.model.Board;
import game.tictactoe.model.CellState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;

public class BoardView extends Canvas {
	
	private final GraphicsContext ctx;
	
	private static final double RADIUS = 0.25;
	private static final double LINE_WIDTH = RADIUS / 4.0;
	private static final double OFFSET = 0.25;
	
	private Affine affine;
	
	public BoardView(double width, double height) {
		super(width, height);
		
		// graphics context
		ctx = super.getGraphicsContext2D();
		
		this.resize(width, height);
		
		ctx.setLineWidth(LINE_WIDTH);
		
		// TODO: Themes
		ctx.setFill(Color.LIGHTGRAY);
		ctx.setStroke(Color.BLACK);
		
		this.reset();
	}
	
	public void draw(Board board) {
		this.reset();
		for (int y = 0; y < Board.SIZE; y++) {
			for (int x = 0; x < Board.SIZE; x++) {
				CellState cellState = board.getCellState(x, y);
				if (cellState == CellState.X) {
					drawX(x + OFFSET, y + OFFSET);
				} else if (cellState == CellState.O) {
					drawO(x + OFFSET, y + OFFSET);
				}
			}
		}
	}
	
	private void drawX(double x, double y) {
		ctx.strokeLine(x, y, x + RADIUS * 2, y + RADIUS * 2);
		ctx.strokeLine(x + RADIUS * 2, y, x, y + RADIUS * 2);
	}
	
	private void drawO(double x, double y) {
		ctx.strokeOval(x, y, RADIUS * 2, RADIUS * 2);
	}
	
	public void reset() {
		ctx.fillRect(0, 0, Board.SIZE, Board.SIZE);
		
		// Vertical Lines
		ctx.strokeLine(1, 0, 1, Board.SIZE);
		ctx.strokeLine(2, 0, 2, Board.SIZE);
		
		// Horizontal Lines
		ctx.strokeLine(0, 1, Board.SIZE, 1);
		ctx.strokeLine(0, 2, Board.SIZE, 2);
	}
	
	@Override
	public void resize(double width, double height) {
		super.resize(width, height);
		
		// transformation scale
		affine = new Affine(new Scale(width / ((double) Board.SIZE), height / ((double) Board.SIZE)));
		ctx.setTransform(affine);
	}
	
	public Affine getAffine() {
		return affine;
	}
	
	@Override
	public boolean isResizable() {
		return true;
	}
	
}
