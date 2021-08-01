package game.tictactoe.players.classic;

import game.tictactoe.managers.GameManager;
import game.tictactoe.managers.UIManager;
import game.tictactoe.models.Board;
import game.tictactoe.models.states.CellState;
import game.tictactoe.models.Move;
import game.tictactoe.views.BoardView;
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
