package game.tictactoe.managers;

import game.tictactoe.Main;
import game.tictactoe.activities.Activity;
import game.tictactoe.models.states.ApplicationConfiguration;
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
		}
		return instance;
	}
	
	public void startActivity(Class<? extends Activity> activityClass) {
		try {
			Activity newActivity = this.activities.push(activityClass.getConstructor().newInstance());
			this.setView(newActivity.getView());
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void destroyActivity(Activity activity) {
		if (activity == this.activities.peek()) {
			Activity endedActivity = this.activities.pop();
			endedActivity.destroy();
		}
		this.setView(this.activities.peek().getView());
	}
	
	public void setView(Parent root) {
		this.applicationConfiguration.bindWidthNHeight((Region) root);
		Main.setSceneRoot(root);
	}
	
	public ApplicationConfiguration getApplicationConfiguration() {
		return this.applicationConfiguration;
	}
}
