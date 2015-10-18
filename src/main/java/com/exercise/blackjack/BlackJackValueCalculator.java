package com.exercise.blackjack;

import java.util.Collection;

import com.exercise.game.ValueCalculatorInf;
import com.exercise.model.Card;

/**
 * Does the Black Jack value calculation 
 * @author alan
 *
 */
public class BlackJackValueCalculator implements ValueCalculatorInf<Card, Integer> {
	private static ValueCalculatorInf<Card, Integer> calculator = new BlackJackValueCalculator();
	
	private BlackJackValueCalculator() {
		
	}
	
	public static ValueCalculatorInf<Card, Integer> getInstance() {
		return calculator;
	}

	/**
	 * Black Jack calculation specific 
	 */
	public Integer calculateValue(Collection<Card> items) {
		int value = 0;
        for(Card item : items) {
        value += doCalculateValue(item);	
        }
       
        return value;
	}
	
	private int doCalculateValue(Card item) {
		if(item.getValue() >=2 && item.getValue() <= 10) {
			return item.getValue();
		}else if(item.getValue() >10 && item.getValue() <=13) {
			return 10;
		}else if(item.getValue() == 1) {
			return 11;
		}else {
			throw new IllegalArgumentException("Card "  + item.toString() + " is invalid ");
		}
	}
	
   }