package game.tictactoe.views;

import javafx.scene.Node;

public interface ResizableView {
	
	void resize(double width, double height);
	
	Node getRoot();
}
