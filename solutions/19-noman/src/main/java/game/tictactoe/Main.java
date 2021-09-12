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
		StartApplication(primaryStage);
	}
	
	public static void StartApplication(Stage primaryStage) {
		primaryStage.setScene(Main.scene);
		ApplicationManager.getInstance().startActivity(MainActivity.class);
		primaryStage.setTitle("Ultimate Tic Tac Toe");
		primaryStage.show();
	}
	
	public static void setSceneRoot(Parent root) {
		Main.scene.setRoot(root);
	}
	
	public static void setRootStyle(String stylesheetPath) {
		Main.scene.getStylesheets().clear();
		Main.scene.getStylesheets().add(stylesheetPath);
	}
}
