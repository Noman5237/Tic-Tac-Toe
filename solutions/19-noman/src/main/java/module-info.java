module game.tictactoe {
	requires javafx.controls;
	requires javafx.graphics;
	
	exports game.tictactoe.model;
	exports game.tictactoe.view;
	exports game.tictactoe.controller.player;
	exports game.tictactoe.manager;
	exports game.tictactoe;
}