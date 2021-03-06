package game.tictactoe.managers;

import game.tictactoe.Main;
import game.tictactoe.activities.Activity;
import game.tictactoe.config.ApplicationConfiguration;
import game.tictactoe.models.Theme;
import javafx.scene.Parent;
import javafx.scene.layout.Region;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class ApplicationManager {
	
	private static ApplicationManager instance;
	
	private final Stack<Activity> activities;
	private final ApplicationConfiguration applicationConfiguration;
	
	private ApplicationManager() {
		this.activities = new Stack<>();
		this.applicationConfiguration = new ApplicationConfiguration();
	}
	
	public static ApplicationManager getInstance() {
		if (instance == null) {
			instance = new ApplicationManager();
			instance.applicationConfiguration.setTheme(Theme.loadTheme("Default"));
		}
		return instance;
	}
	
	public void startActivity(Class<? extends Activity> activityClass) {
		try {
			Activity newActivity = this.activities.push(activityClass.getConstructor().newInstance());
			this.setView((Parent) newActivity.getView().getRoot());
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void destroyCurrentActivity() {
		Activity endedActivity = this.activities.pop();
		endedActivity.onDestroy();
		this.setView((Parent) this.activities.peek().getView().getRoot());
	}
	
	public void setView(Parent root) {
		this.applicationConfiguration.bindWindow((Region) root);
		Main.setSceneRoot(root);
	}
	
	public ApplicationConfiguration getApplicationConfiguration() {
		return this.applicationConfiguration;
	}
	
	public Activity getCurrentActivity() {
		return this.activities.peek();
	}
}
