package com.exercise.blackjack;

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.exercise.game.DeckInf;
import com.exercise.game.LoggerInf;
import com.exercise.game.RuleBasedInf;
import com.exercise.game.ValueCalculatorInf;
import com.exercise.model.Card;
import com.exercise.model.Player;

public class BlackJackRuledBased implements RuleBasedInf<Player, DeckInf, Boolean,PrintStream, String> {

	public Boolean applyRule(List<Player> players, DeckInf deck, LoggerInf<PrintStream, String> logger ) {
		logger.log("*******************\n\n");
		logger.log("round starts ....");
		logger.log("*******************");
		List<Player> sticks = new LinkedList<Player>();
		boolean hit21 = false; 
		ValueCalculatorInf<Card, Integer> calculator = BlackJackValueCalculator.getInstance();
		ListIterator<Player> iter = players.listIterator();
		while(iter.hasNext()){
			Player player = iter.next();
			int value = player.getValue(calculator);
			logger.log( player.toString() + " has value:" + value);
		    if(value <= 17){
		    	logger.log( player.toString() + " has hit");
		        player.addCard((Card)deck.dealCard());
		    }else if(value> 17 && value <21) {
		    	logger.log( player.toString() + " has stick");
		    	 sticks.add(player);
		    }else if(value > 21) {
		    	logger.log( player.toString() + " has been kicked out");
		    	iter.remove();
		    }else if( value == 21) {
		    	logger.log( player.toString() + " has hit 21");
		    	hit21 = true;
		    }
		}
		
		logger.log("stick size: "  + sticks.size() + "  player size : " + players.size());
		
	   return (sticks.size() == players.size() || hit21  || players.size() == 1);
	}
	
	public Player getWinner(List<Player> players,LoggerInf<PrintStream, String> logger ) {
		logger.log("trying to find the winner");
		Player winner = null;
		Collections.sort(players, new WinnerComparator());
		ValueCalculatorInf<Card, Integer> calculator = BlackJackValueCalculator.getInstance();
		for(Player player :players) {
			int value = player.getValue(calculator);
			if(value == 21) {
				logger.log("Palyer " +  player.toString()  + " is the winner because he has 21");
			   winner = player;
			   break;
			}
		}
		
		if(winner == null && players.size()>0) {
			int value = players.get(0).getValue(calculator);
			logger.log("Palyer " +   players.get(0).toString()  + " selected from top who has value " + value);
			winner =  players.get(0); // top one
		}
		
		return winner;
	}
	
	private class WinnerComparator implements Comparator<Player> {

		public int compare(Player o1, Player o2) {
			ValueCalculatorInf<Card, Integer> calculator = BlackJackValueCalculator.getInstance();
			int value1 = o1.getValue(calculator);
			int value2 = o2.getValue(calculator);
			if(value1 == value2) {
				return 0;
			}else if(value1 > value2) {
				return -1;
			}else {
				return 1;
			}
		}
		
	}

}
