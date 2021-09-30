package game.tictactoe.managers;

import game.tictactoe.Main;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith (ApplicationExtension.class)
public class GameManagerTest {
	
	@Start
	public void start(Stage stage) {
		Main.StartApplication(stage);
	}
	
	@Test
	@DisplayName ("Game Manager is a singleton class")
	void gameActivityStartsWhenPlayButtonClicked() {
		GameManager gameManager1 = GameManager.getInstance();
		GameManager gameManager2 = GameManager.getInstance();
		Assertions.assertEquals(gameManager1, gameManager2);
	}
	
}
