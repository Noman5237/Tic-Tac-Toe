package game.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label helloJavaFX = new Label("Hello JavaFX");
		Scene scene = new Scene(helloJavaFX, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello");
		primaryStage.show();
	}
}
