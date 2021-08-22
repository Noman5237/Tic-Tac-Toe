package game.tictactoe.activities.optionsactivity;

import game.tictactoe.managers.ApplicationManager;
import game.tictactoe.models.Theme;
import game.tictactoe.views.optionsview.GraphicsView;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class Graphics {
	
	private final GraphicsView graphicsView;
	
	public Graphics(GraphicsView graphicsView) {
		this.graphicsView = graphicsView;
		this.setupThemeOptions();
		this.setupActions();
	}
	
	private void setupThemeOptions() {
		Arrays.asList(Objects.requireNonNull(Paths.get(ApplicationManager.getInstance().getApplicationStoragePath(), "Themes").toFile().list()))
				.forEach(themeName -> this.graphicsView.getThemes().getItems().add(themeName));
	}
	
	private void setupActions() {
		this.graphicsView.getThemes().setOnAction(event -> {
			String selectedTheme = this.graphicsView.getThemes().getSelectionModel().getSelectedItem();
			ApplicationManager.getInstance().setTheme(Theme.loadTheme(selectedTheme));
		});
	}
	
}
