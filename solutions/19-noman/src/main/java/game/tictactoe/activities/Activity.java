package game.tictactoe.activities;
import game.tictactoe.views.ResizableView;

public interface Activity {
	
	ResizableView getView();
	
	void onDestroy();
}
