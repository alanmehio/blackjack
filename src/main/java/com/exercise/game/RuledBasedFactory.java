package com.exercise.game;

import java.io.PrintStream;

import com.exercise.blackjack.BlackJackRuledBased;
import com.exercise.model.Player;


public class RuledBasedFactory {
	public enum GameType {
		BLACKJACK, POCKER, RUMMY;
	};
	
	public static RuleBasedInf<Player, DeckInf, Boolean,PrintStream, String>  getRuledBased(GameType gameType) {
		if(gameType == GameType.BLACKJACK) {
			return new BlackJackRuledBased();
		}else {
			throw new IllegalArgumentException("No implementation yet");
		}
	}
}
