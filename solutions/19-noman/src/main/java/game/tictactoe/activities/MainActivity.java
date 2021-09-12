package game.tictactoe.activities;

import game.tictactoe.activities.optionsactivity.OptionsActivity;
import game.tictactoe.config.ApplicationConfiguration;
import game.tictactoe.managers.ApplicationManager;
import game.tictactoe.managers.GameManager;
import game.tictactoe.views.MainView;
import javafx.beans.value.ChangeListener;

public class MainActivity implements Activity {
	
	private MainView mainView;
	private final ApplicationConfiguration applicationConfiguration;
	ApplicationManager applicationManager;
	private ChangeListener<Boolean> applicationConfigurationChangeListener;
	
	public MainActivity() {
		this.applicationManager = ApplicationManager.getInstance();
		this.applicationConfiguration = this.applicationManager.getApplicationConfiguration();
		this.initializeView();
		this.setupListeners();
		this.setupActions();
	}
	
	private void initializeView() {
		double windowWidth = this.applicationConfiguration.getWindowWidth();
		double windowHeight = this.applicationConfiguration.getWindowHeight();
		this.mainView = new MainView(windowWidth, windowHeight);
		this.mainView.resize(windowWidth, windowHeight);
	}
	
	private void setupListeners() {
		this.applicationConfigurationChangeListener = (observable, oldValue, newValue) -> this.mainView.resize(this.applicationConfiguration.getWindowWidth(), this.applicationConfiguration.getWindowHeight());
		this.applicationConfiguration.addListener(this.applicationConfigurationChangeListener);
	}
	
	private void setupActions() {
		this.mainView.getPlayButton().setOnAction(event -> {
			this.applicationManager.startActivity(GameActivity.class);
			GameManager.getInstance().start();
		});
		
		this.mainView.getOptionsButton().setOnAction(event -> {
			this.applicationManager.startActivity(OptionsActivity.class);
		});
	}
	
	@Override
	public MainView getView() {
		return this.mainView;
	}
	
	@Override
	public void onDestroy() {
		this.applicationConfiguration.removeListener(this.applicationConfigurationChangeListener);
	}
}
