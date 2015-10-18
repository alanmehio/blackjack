package com.exercise.game;

import java.util.Collection;

public interface ValueCalculatorInf<C,I> {
	
	/**
	 * Calculate certain given value 
	 * implementation  specific
	 * @param items given items to loop through and calculate final value
	 * @return the value to be calculated
	 */
	public I calculateValue(Collection<C> items);

}
