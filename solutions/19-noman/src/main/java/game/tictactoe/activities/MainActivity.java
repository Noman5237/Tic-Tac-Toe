package game.tictactoe.activities;

import game.tictactoe.managers.ApplicationManager;
import game.tictactoe.models.states.ApplicationConfiguration;
import game.tictactoe.views.MainView;
import javafx.beans.value.ChangeListener;
import javafx.scene.Parent;

public class MainActivity implements Activity {
	
	private MainView mainView;
	private final ApplicationConfiguration applicationConfiguration;
	private ChangeListener<Boolean> applicationConfigurationChangeListener;
	
	public MainActivity() {
		this.applicationConfiguration = ApplicationManager.getInstance().getApplicationConfiguration();
		this.initializeMainView();
		this.setupListeners();
	}
	
	private void initializeMainView() {
		double windowWidth = this.applicationConfiguration.getWindowWidth();
		double windowHeight = this.applicationConfiguration.getWindowHeight();
		this.mainView = new MainView(windowWidth, windowHeight);
		this.mainView.resize(windowWidth, windowHeight);
	}
	
	private void setupListeners() {
		this.applicationConfigurationChangeListener = (observable, oldValue, newValue) -> this.mainView.resize(this.applicationConfiguration.getWindowWidth(), this.applicationConfiguration.getWindowHeight());
		this.applicationConfiguration.addListener(this.applicationConfigurationChangeListener);
	}
	
	@Override
	public Parent getView() {
		return this.mainView.getRoot();
	}
	
	@Override
	public void destroy() {
		this.applicationConfiguration.removeListener(this.applicationConfigurationChangeListener);
	}
}
