package com.exercise.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.exercise.blackjack.BlackJackValueCalculator;
import com.exercise.game.ValueCalculatorInf;
import com.exercise.model.Card;

public class BlackJackValueCalculatorTest {
	private ValueCalculatorInf<Card, Integer> calculator;
	
	@Before
	public void setUp() throws Exception {
		calculator = BlackJackValueCalculator.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void  aceValue() {
		Collection<Card> cards = new ArrayList<Card>();
		Card card = new Card(1, Card.Suit.SPADES);
		cards.add(card);
		int expectedValue = calculator.calculateValue(cards);
		assertEquals(expectedValue, 11);
	}
	
	@Test
	public void two_ten_value() {
		Collection<Card> cards = new ArrayList<Card>();
		Card card = new Card(10, Card.Suit.SPADES);
		cards.add(card);
		card = new Card(2,Card.Suit.SPADES);
		cards.add(card);
		int expectedValue = calculator.calculateValue(cards);
		assertEquals(expectedValue, 12);
	}
	
	@Test
	public void jack_queens_king_value() {
		Collection<Card> cards = new ArrayList<Card>();
		Card card = new Card(11, Card.Suit.SPADES);
		cards.add(card);
		card = new Card(12,Card.Suit.SPADES);
		cards.add(card);
		
		card = new Card(13,Card.Suit.SPADES);
		cards.add(card);
		int expectedValue = calculator.calculateValue(cards);
		assertEquals(expectedValue, 30);
	}

}
