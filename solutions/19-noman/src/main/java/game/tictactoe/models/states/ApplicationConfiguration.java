package game.tictactoe.models.states;

import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class ApplicationConfiguration {
	
	private final double defaultWindowWidth = 600;
	private final double defaultWindowHeight = 800;
	
	private double windowWidth = defaultWindowWidth;
	private double windowHeight = defaultWindowHeight;
	private double windowScaleX = 1;
	private double windowScaleY = 1;
	
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
	
	public void bindWindow(Region window) {
		window.widthProperty().addListener((observable, oldWidth, newWidth) -> {
			this.setWindowWidth(newWidth.doubleValue());
		});
		
		window.heightProperty().addListener((observable, oldHeight, newHeight) -> {
			this.setWindowHeight(newHeight.doubleValue());
		});
	}
	
	public void setWindowWidth(double windowWidth) {
		this.setWindowScaleX(windowWidth / defaultWindowWidth);
		this.windowWidth = windowWidth;
		this.notifyListeners();
	}
	
	public void setWindowHeight(double windowHeight) {
		this.setWindowScaleY(windowHeight / defaultWindowHeight);
		this.windowHeight = windowHeight;
		this.notifyListeners();
	}
	
	public void setWindowScaleX(double windowScaleX) {
		this.windowScaleX = windowScaleX;
		this.notifyListeners();
	}
	
	public void setWindowScaleY(double windowScaleY) {
		this.windowScaleY = windowScaleY;
		this.notifyListeners();
	}
	
	public double getWindowWidth() {
		return this.windowWidth;
	}
	
	public double getWindowHeight() {
		return this.windowHeight;
	}
	
	public double getWindowScaleX() {
		return windowScaleX;
	}
	
	public double getWindowScaleY() {
		return windowScaleY;
	}
}
