package game.tictactoe.models;

import game.tictactoe.managers.ApplicationManager;
import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class Theme {
	
	private final String name;
	private final Image board;
	private final Image X;
	private final Image O;
	private final String stylesheetPath;
	
	public Theme(String name, Image board, Image x, Image o, String stylesheetPath) {
		this.name = name;
		this.board = board;
		this.X = x;
		this.O = o;
		this.stylesheetPath = stylesheetPath;
	}
	
	public static Theme loadTheme(String themeName) {
		File[] themeDir = Objects.requireNonNull(Paths.get(ApplicationManager.getInstance().getApplicationStoragePath(), "Themes", themeName).toFile().listFiles());
		var themePaths = new Object() {
			private String stylesheetPath;
			private String boardPath;
			private String XPath;
			private String OPath;
		};
		
		Arrays.stream(themeDir).filter(file -> file.toString().contains("Board")).findFirst().ifPresent(file -> themePaths.boardPath = file.toURI().toString());
		Arrays.stream(themeDir).filter(file -> file.toString().contains("X")).findFirst().ifPresent(file -> themePaths.XPath = file.toURI().toString());
		Arrays.stream(themeDir).filter(file -> file.toString().contains("O")).findFirst().ifPresent(file -> themePaths.OPath = file.toURI().toString());
		Arrays.stream(themeDir).filter(file -> file.toString().contains("style")).findFirst().ifPresent(file -> themePaths.stylesheetPath = file.toURI().toString());
		
		return new Theme(themeName, new Image(themePaths.boardPath), new Image(themePaths.XPath), new Image(themePaths.OPath), themePaths.stylesheetPath);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Image getBoard() {
		return this.board;
	}
	
	public Image getX() {
		return this.X;
	}
	
	public Image getO() {
		return this.O;
	}
	
	public String getStylesheetPath() {
		return this.stylesheetPath;
	}
}
