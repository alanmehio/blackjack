package com.exercise.game;
import java.io.Console;

import com.exercise.game.CardShufflerFactory.ShuffleType;
import com.exercise.game.RuledBasedFactory.GameType;

/**
 * Console Parser 
 * @author alan
 *
 */
public final class ConsoleParser {
		
	private ConsoleParser() {
		
	}

	public static void parse(HolderInf<Integer,ShuffleType, GameType > holder) {
		Console console = System.console();
		int numberOfPlayers = 3;
		String players = console.readLine("Number of Players? ");
		if (players.length() == 0) {
			String msg = " Number of player given is empty; it should be at least one or at most 6 players; we will default to 3\n";
			printHelp(console, msg);
			numberOfPlayers = 3;
		} else {
			numberOfPlayers = Integer.parseInt(players);
		}

		if (numberOfPlayers <= 0 || numberOfPlayers >= 6) {
			String msg = " Number of player given is "
					+ numberOfPlayers
					+ "; it should be at least one or at most 6 players; we will default to 3\n";
			printHelp(console, msg);
			numberOfPlayers = 3;
		}

		String shufflerStr = console
				.readLine("Entery the shuffling implementation random, riffle, pharon, faro? ");
		ShuffleType shuffleType = ShuffleType
				.valueOf(shufflerStr.toUpperCase());

		String gameTypeStr = console
				.readLine("Entery the game? can be of the following : blackjack, poker, rummy? ");
		GameType gameType = GameType.valueOf(gameTypeStr.toUpperCase());

		console.printf(
				"Following has been entered: players: %1$d, shuffle implementation: %2$s, card game: %3$s",
				numberOfPlayers, shufflerStr, gameTypeStr);
		
		holder.popluateHolder(numberOfPlayers, shuffleType, gameType);
	}

	private static void printHelp(Console console, String message) {
		console.printf(message);
	}

}
