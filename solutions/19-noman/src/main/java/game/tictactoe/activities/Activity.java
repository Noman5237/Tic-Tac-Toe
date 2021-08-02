package game.tictactoe.activities;

import javafx.scene.Node;
import javafx.scene.Parent;

public interface Activity {
	
	Parent getView();
	
	void destroy();
}
