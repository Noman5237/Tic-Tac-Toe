package game.tictactoe;

import game.tictactoe.controller.player.UIPlayer;
import game.tictactoe.controller.player.ai.RandomAIPlayer;
import game.tictactoe.manager.GameManager;
import game.tictactoe.manager.UIManager;
import game.tictactoe.model.CellState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(UIManager.getInstance().getSceneRoot());
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX");
		primaryStage.show();
		GameManager.getInstance().setPlayer1(new UIPlayer(CellState.X));
		GameManager.getInstance().setPlayer2(new RandomAIPlayer(CellState.O));
		GameManager.getInstance().start();
	}
}
