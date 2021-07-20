package game.tictactoe;

import game.tictactoe.model.Board;
import game.tictactoe.model.CellState;
import game.tictactoe.view.BoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Board board = new Board();
		board.setCellState(0, 0, CellState.O);
		board.setCellState(0, 1, CellState.X);
		board.setCellState(1, 1, CellState.X);
		board.setCellState(2, 0, CellState.X);
		board.setCellState(0, 2, CellState.O);
		BoardView boardView = new BoardView(800, 800);
		boardView.draw(board);
		Scene scene = new Scene(boardView);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX");
		primaryStage.show();
	}
}
