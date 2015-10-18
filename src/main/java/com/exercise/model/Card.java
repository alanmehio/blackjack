package com.exercise.model;

import com.exercise.util.StringUtils;

/**
 * card model
 * 
 * @author alan
 *
 */
public class Card {
	
	 public enum Suit {
		 SPADES, HEARTS, DIAMONDS, CLUBS; 
	 }


	/**
	 * SPADES, HEARTS, DIAMONDS, CLUBS
	 */
	private final Suit suit; 
					
    /**
     * The value of this card, from 1 to 13
     */
	private final int value; 

	/**
	 * 
	 * @param theValue
	 * @param theSuit
	 */
	public Card(int value, Suit suit ) {
		if(value <1 || value > 13) {
			throw new IllegalArgumentException("value: '" + value + "' is not in the range ");
		}
		
		if(suit == null) {
			throw new NullPointerException("suit is Null ");
		}
		
		this.value = value;
		this.suit = suit;
	}

	/**
	 * 
	 * @return the card suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * 
	 * @return the card value
	 */
	public int getValue() {
		return value;
	}

	
    /**
     * 
     */
	public String toString() {
		return StringUtils.toString(this);
	}

}
