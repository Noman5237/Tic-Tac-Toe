package game.tictactoe.views;

import javafx.scene.Node;
import javafx.scene.Parent;

public interface View {
	
	void resize(double width, double height);
	
	Parent getRoot();
}
