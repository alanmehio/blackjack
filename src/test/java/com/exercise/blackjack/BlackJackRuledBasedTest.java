/**
 * 
 */
package com.exercise.blackjack;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.exercise.blackjack.BlackJackRuledBased;
import com.exercise.blackjack.BlackJackValueCalculator;
import com.exercise.blackjack.ConsoleLogger;
import com.exercise.game.DeckInf;
import com.exercise.game.LoggerInf;
import com.exercise.game.RuleBasedInf;
import com.exercise.game.ValueCalculatorInf;
import com.exercise.model.Card;
import com.exercise.model.Player;

/**
 * @author alan
 *
 */
public class BlackJackRuledBasedTest {
	private RuleBasedInf<Player, DeckInf, Boolean, PrintStream,String> rule;
	private  ValueCalculatorInf<Card, Integer> calculator;
	private List<Player> players;
	private DeckInf deck;
	private LoggerInf<PrintStream, String> logger;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rule = new BlackJackRuledBased();
		players = new LinkedList<Player>();
		calculator = BlackJackValueCalculator.getInstance();
		logger = new ConsoleLogger();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		rule = null;
		players = null;
		calculator = null;
		logger = null;
	}

	@Test
	public void hit() {
		Card card = new Card(2,Card.Suit.CLUBS);
		deck = new MyDeck(card);
		Player player1 = new Player("A");
		card = new Card(2,Card.Suit.CLUBS);
		player1.addCard(card);
		players.add(player1);
		rule.applyRule(players, deck, logger);
		int value = player1.getValue(calculator);
		assertEquals(4, value);
		
	}
	
	@Test
	public void stick() {
		Card card = new Card(2,Card.Suit.CLUBS);
		deck = new MyDeck(card);
		Player player1 = new Player("A");
		card = new Card(10,Card.Suit.CLUBS);
		player1.addCard(card);
		card = new Card(10,Card.Suit.CLUBS);
		player1.addCard(card);
		players.add(player1);
		rule.applyRule(players, deck, logger);
		int value = player1.getValue(calculator);
		assertEquals(20, value);
		
	}
	
	private static class MyDeck implements DeckInf {
		private Card card;
		
		public MyDeck(Card card)  {
			this.card = card;
		}

		public void shuffle() {
			// TODO Auto-generated method stub
			
		}

		public int cardsLeft() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Card dealCard() {
		  return card;
		}
		
	}
}
