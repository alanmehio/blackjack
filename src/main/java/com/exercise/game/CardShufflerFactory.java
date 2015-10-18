package com.exercise.game;

import com.exercise.model.Card;

public class CardShufflerFactory {
	public enum ShuffleType {
	 RANDOM, RIFFLE, PHAROAH, FARO;
	}
	
	public static ShufflerInf<Card> getCardShuffle(CardShufflerFactory.ShuffleType type) {
		switch(type) {
		case RANDOM :
			return new RandomShuffler();
		default: 
			throw new IllegalArgumentException("No implementation yet");
		}
	}

}
