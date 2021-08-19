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
		X = x;
		O = o;
		this.stylesheetPath = stylesheetPath;
	}
	
	public static Theme loadTheme(String themeName) {
		String themeDir = Paths.get(ApplicationManager.getInstance().getPreferencePath(), "Themes", themeName).toString();
		String boardPath = Paths.get(themeDir, "Board.png").toUri().toString();
		String XPath = Paths.get(themeDir, "X.png").toUri().toString();
		String OPath = Paths.get(themeDir, "O.png").toUri().toString();
		String stylesheetPath = Paths.get(themeDir, "style.css").toUri().toString();
		return new Theme(themeName, new Image(boardPath), new Image(XPath), new Image(OPath), stylesheetPath);
	}
	
	public String getName() {
		return name;
	}
	
	public Image getBoard() {
		return board;
	}
	
	public Image getX() {
		return X;
	}
	
	public Image getO() {
		return O;
	}
	
	public String getStylesheetPath() {
		return stylesheetPath;
	}
}
