package game.tictactoe.activities.optionsactivity;

import game.tictactoe.activities.Activity;
import game.tictactoe.views.ResizableView;
import game.tictactoe.views.optionsview.OptionsView;

public class OptionsActivity implements Activity {
	
	private final OptionsView optionsView;
	
	public OptionsActivity() {
		this.optionsView = new OptionsView();
		new Graphics(this.optionsView.getGraphicsView());
	}
	
	@Override
	public ResizableView getView() {
		return this.optionsView;
	}
	
	@Override
	public void onDestroy() {
	
	}
}
