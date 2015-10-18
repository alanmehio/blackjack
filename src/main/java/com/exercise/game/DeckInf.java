package com.exercise.game;

public interface DeckInf {
	/**
	 * Card left in the deck
	 * @return
	 */
	public int cardsLeft();
	
	public <C> C dealCard();
}
