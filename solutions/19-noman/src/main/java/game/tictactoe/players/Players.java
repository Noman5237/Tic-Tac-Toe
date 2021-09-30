package game.tictactoe.players;

import game.tictactoe.players.ai.DefensiveAIPlayer;
import game.tictactoe.players.ai.RandomAIPlayer;

public enum Players {
	UIPlayer(game.tictactoe.players.UIPlayer.class, "Human Player"),
	RandomAIPlayer(RandomAIPlayer.class, "Random AI"),
	DefensivePlayer(DefensiveAIPlayer.class, "Defensive AI");
	
	private final Class<? extends Player> playerClass;
	private final String representation;
	
	Players(Class<? extends Player> playerClass, String representation) {
		this.playerClass = playerClass;
		this.representation = representation;
	}
	
	public Class<? extends Player> getPlayerClass() {
		return this.playerClass;
	}
	
	@Override
	public String toString() {
		return this.representation;
	}
}
