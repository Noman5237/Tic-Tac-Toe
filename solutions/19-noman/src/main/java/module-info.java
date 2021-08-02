module game.tictactoe {
	requires javafx.controls;
	requires javafx.graphics;
	
	exports game.tictactoe.models;
	exports game.tictactoe.activities;
	exports game.tictactoe.players.classic;
	exports game.tictactoe.managers;
	exports game.tictactoe;
	exports game.tictactoe.views;
	exports game.tictactoe.models.states;
	exports game.tictactoe.views.gameview;
}