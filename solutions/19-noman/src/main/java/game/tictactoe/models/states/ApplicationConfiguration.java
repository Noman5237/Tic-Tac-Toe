package game.tictactoe.models.states;

import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class ApplicationConfiguration {
	
	private double windowWidth = 600;
	private double windowHeight = 800;
	
	ArrayList<ChangeListener<Boolean>> listeners;
	
	public ApplicationConfiguration() {
		this.listeners = new ArrayList<>();
	}
	
	public void addListener(ChangeListener<Boolean> changeListener) {
		this.listeners.add(changeListener);
	}
	
	public void removeListener(ChangeListener<Boolean> changeListener) {
		this.listeners.remove(changeListener);
	}
	
	public void notifyListeners() {
		this.listeners.forEach(listener -> listener.changed(null, null, null));
	}
	
	public void bindWidthNHeight(Region pane) {
		pane.widthProperty().addListener((observable, oldWidth, newWidth) -> {
			this.windowWidth = (double) newWidth;
			this.notifyListeners();
		});
		
		pane.heightProperty().addListener((observable, oldHeight, newHeight) -> {
			this.windowHeight = (double) newHeight;
			this.notifyListeners();
		});
	}
	
	public double getWindowWidth() {
		return this.windowWidth;
	}
	
	public double getWindowHeight() {
		return this.windowHeight;
	}
}
