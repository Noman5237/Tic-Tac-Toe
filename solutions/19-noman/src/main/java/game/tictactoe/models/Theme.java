package game.tictactoe.models;

import game.tictactoe.managers.ApplicationManager;
import javafx.scene.image.Image;

import java.nio.file.Paths;

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
		String themeDir = Paths.get(ApplicationManager.getInstance().getApplicationConfiguration().getApplicationStoragePath(), "Themes", themeName).toString();
		String boardPath = Paths.get(themeDir, "Board.png").toUri().toString();
		String XPath = Paths.get(themeDir, "X.png").toUri().toString();
		String OPath = Paths.get(themeDir, "O.png").toUri().toString();
		String stylesheetPath = Paths.get(themeDir, "style.css").toUri().toString();
		return new Theme(themeName, new Image(boardPath), new Image(XPath), new Image(OPath), stylesheetPath);
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
