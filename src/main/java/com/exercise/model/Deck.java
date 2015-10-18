package com.exercise.model;

import com.exercise.game.DeckInf;
import com.exercise.game.ShufflerInf;

public class Deck implements DeckInf {

	/**
	 * An array of 52 Cards, representing the deck 
	 */
	private Card[] deck; 
	
	/**
	 *  How many cards have been dealt from the deck
	 */
	private int cardsUsed;
	
	private ShufflerInf<Card> shuffler;

	/**
	 * create unshuffled deck of cards
	 */
	public Deck( ShufflerInf<Card> shuffler) {
		this.shuffler = shuffler;
		deck = new Card[52];
		int cardCt = 0; // How many cards have been created so far.
		for(Card.Suit  suit : Card.Suit.values()) {
			for (int value = 1; value <= 13; value++) {
				deck[cardCt] = new Card(value, suit);
				cardCt++;
			}
		}

		cardsUsed = 0;
	}

	/**
	 * Shuffle the card 
	 */
	public void shuffle() {
		 this.shuffler.shuffle(deck);
	}

	
	@Override
	public int cardsLeft() {
		return 52 - cardsUsed;
	}

	@Override
	public Card dealCard() {
		if (cardsUsed == 52)
			shuffle();
		cardsUsed++;
		return deck[cardsUsed - 1];
	}

}