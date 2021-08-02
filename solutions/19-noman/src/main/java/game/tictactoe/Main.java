package game.tictactoe;

import game.tictactoe.activities.MainActivity;
import game.tictactoe.managers.ApplicationManager;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final Scene scene = new Scene(new Pane());
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(Main.scene);
		ApplicationManager.getInstance().startActivity(MainActivity.class);
		primaryStage.setTitle("Ultimate Tic Tac Toe");
		primaryStage.show();
	}
	
	public static void setSceneRoot(Parent root) {
		Main.scene.setRoot(root);
	}
	
	
}
