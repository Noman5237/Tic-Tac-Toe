package game.tictactoe;

import game.tictactoe.managers.GameManager;
import game.tictactoe.models.states.CellState;
import game.tictactoe.players.classic.UIPlayer;
import game.tictactoe.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GameManager.getInstance().setPlayer1(new UIPlayer(CellState.X));
		GameManager.getInstance().setPlayer2(new UIPlayer(CellState.O));
		Scene scene = new Scene(new MainView(600, 600));
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX");
		primaryStage.show();
		GameManager.getInstance().start();
	}
}
