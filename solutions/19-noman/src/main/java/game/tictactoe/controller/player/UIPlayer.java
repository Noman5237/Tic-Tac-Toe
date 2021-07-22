package game.tictactoe.controller.player;

import game.tictactoe.manager.GameManager;
import game.tictactoe.manager.UIManager;
import game.tictactoe.model.Board;
import game.tictactoe.model.CellState;
import game.tictactoe.model.Move;
import game.tictactoe.view.BoardView;
import javafx.geometry.Point2D;
import javafx.scene.transform.NonInvertibleTransformException;

public class UIPlayer extends Player {
	
	
	public UIPlayer(CellState playerSymbol) {
		super(playerSymbol);
	}
	
	@Override
	public void promptForNextMove(Board board) {
		BoardView boardView = UIManager.getInstance().getBoardView();
		boardView.setOnMouseClicked(mouseEvent -> {
			try {
				Point2D point2D = boardView.getAffine().inverseTransform(mouseEvent.getX(), mouseEvent.getY());
				Move nextMove = new Move(((int) point2D.getX()), ((int) point2D.getY()), super.getPlayerSymbol());
				if (board.getCellState(nextMove.getX(), nextMove.getY()) != CellState.EMPTY) return;
				GameManager.getInstance().setNextMove(nextMove);
			} catch (NonInvertibleTransformException ignored) {
			}
		});
	}
	
}
