package com.exercise.blackjack;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import com.exercise.game.CardShufflerFactory;
import com.exercise.game.ConsoleParser;
import com.exercise.game.DeckInf;
import com.exercise.game.GameParamHolder;
import com.exercise.game.HolderInf;
import com.exercise.game.LoggerInf;
import com.exercise.game.RuleBasedInf;
import com.exercise.game.RuledBasedFactory;
import com.exercise.game.CardShufflerFactory.ShuffleType;
import com.exercise.game.RuledBasedFactory.GameType;
import com.exercise.model.Deck;
import com.exercise.model.Player;

/**
 * Bootstrap class
 * @author alan
 *
 */
public class Main {

	public static void main(String... args) {
		HolderInf<Integer,ShuffleType, GameType > holder = new GameParamHolder();	
		ConsoleParser.parse(holder);

		Deck deck = new Deck(
				CardShufflerFactory.getCardShuffle(holder.getShuffler()));
		deck.shuffle();
		List<Player> players = new LinkedList<Player>();
		for(int i= 1; i <= holder.getPlayerNumber(); i ++) {
		  Player player = new Player("" + i);
		  player.addCard(deck.dealCard());
		  players.add(player); 
	    }
		
		LoggerInf<PrintStream, String> logger = new ConsoleLogger();
		RuleBasedInf<Player, DeckInf, Boolean,PrintStream, String> rule = RuledBasedFactory
				.getRuledBased(holder.getGameType());

		while (true) {
         if( rule.applyRule(players, deck, logger)) {
        	 break;
         }
		}
		
		logger.log("\n");
		logger.log("*****************Result*************************");
		Player winner = rule.getWinner(players, logger);
		if(winner != null) {
			logger.log("");
			logger.log("*****WINNER********");
			logger.log("Player " + winner.toString());
			logger.log("*****WINNER********");
		}
		

	}

}
