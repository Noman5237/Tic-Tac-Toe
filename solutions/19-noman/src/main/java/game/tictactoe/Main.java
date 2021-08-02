package game.tictactoe;

import game.tictactoe.activities.MainActivity;
import game.tictactoe.managers.ApplicationManager;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;
		
		ApplicationManager.getInstance().startActivity(MainActivity.class);
		
		primaryStage.setTitle("Ultimate Tic Tac Toe");
		primaryStage.show();
	}
	
	public static void setSceneRoot(Parent root) {
		primaryStage.setScene(new Scene(root));
	}
	
	
}
