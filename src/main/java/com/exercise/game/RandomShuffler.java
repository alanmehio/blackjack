package com.exercise.game;

import com.exercise.model.Card;

public class RandomShuffler implements ShufflerInf<Card> {

	@Override
	public void shuffle(Card[] deck) {
		for (int i = 51; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
	}

}
