package game.tictactoe.config;

import game.tictactoe.Main;
import game.tictactoe.models.Theme;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Region;

import javax.swing.filechooser.FileSystemView;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ApplicationConfiguration {
	
	private final double defaultWindowWidth = 600;
	private final double defaultWindowHeight = 800;
	
	private double windowWidth = this.defaultWindowWidth;
	private double windowHeight = this.defaultWindowHeight;
	private double windowScaleX = 1;
	private double windowScaleY = 1;
	
	private final String applicationStoragePath;
	private Theme theme;
	
	ArrayList<ChangeListener<Boolean>> listeners;
	
	public ApplicationConfiguration() {
		this.listeners = new ArrayList<>();
		this.applicationStoragePath = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath(), "TicTacToe").toString();
	}
	
	public void addListener(ChangeListener<Boolean> changeListener) {
		this.listeners.add(changeListener);
	}
	
	public void removeListener(ChangeListener<Boolean> changeListener) {
		this.listeners.remove(changeListener);
	}
	
	private void notifyListeners() {
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
		this.setWindowScaleX(windowWidth / this.defaultWindowWidth);
		this.windowWidth = windowWidth;
		this.notifyListeners();
	}
	
	public void setWindowHeight(double windowHeight) {
		this.setWindowScaleY(windowHeight / this.defaultWindowHeight);
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
	
	public void setTheme(Theme theme) {
		this.theme = theme;
		Main.setRootStyle(theme.getStylesheetPath());
		this.notifyListeners();
	}
	
	public double getWindowWidth() {
		return this.windowWidth;
	}
	
	public double getWindowHeight() {
		return this.windowHeight;
	}
	
	public double getWindowScaleX() {
		return this.windowScaleX;
	}
	
	public double getWindowScaleY() {
		return this.windowScaleY;
	}
	
	public String getApplicationStoragePath() {
		return this.applicationStoragePath;
	}
	
	public Theme getTheme() {
		return this.theme;
	}
	
}
