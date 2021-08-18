module game.tictactoe {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	
	exports game.tictactoe.activities;
	exports game.tictactoe.players;
	exports game.tictactoe.managers;
	exports game.tictactoe;
	exports game.tictactoe.views;
	exports game.tictactoe.models.states;
	exports game.tictactoe.views.gameview;
}