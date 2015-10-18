package com.exercise.model;

import java.util.ArrayList;
import java.util.Collection;

import com.exercise.game.ValueCalculatorInf;

public class Player {
	
	private String name;
	private Collection<Card> cards;
	
	
	public Player(String name) {
		this.name = name;
		cards = new ArrayList<Card>();
	}
	
	/**
	 * Give a player a card 
	 * @param c
	 */
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.clear();
	}
	
	/**
	 * Obtain the BlackJack value
	 * @param calculator
	 * @return
	 */
	public int getValue(ValueCalculatorInf<Card, Integer> calculator) {
		return calculator.calculateValue(cards);
	}
	
	public String toString() {
		return "Palyer:" +  name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

}
