package game.tictactoe;


import game.tictactoe.activities.GameActivity;
import game.tictactoe.managers.ApplicationManager;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith (ApplicationExtension.class)
public class WelcomeScreenTest {
	
	@Start
	public void start(Stage stage) {
		Main.StartApplication(stage);
	}
	
	@Test
	@DisplayName ("Game Activity starts when #main-play-button is clicked")
	void gameActivityStartsWhenPlayButtonClicked(FxRobot robot) {
		robot.clickOn("#main-play-button");
		Assertions.assertThat(ApplicationManager.getInstance().getCurrentActivity()).isInstanceOf(GameActivity.class);
	}
}
