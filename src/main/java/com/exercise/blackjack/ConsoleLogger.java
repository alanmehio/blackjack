package com.exercise.blackjack;

import java.io.PrintStream;

import com.exercise.game.LoggerInf;

/**
 * Console logger implementation
 * @author alan
 *
 */
public class ConsoleLogger  implements LoggerInf<PrintStream, String>{
	private PrintStream output = System.out;

	public void log(String s) {
	 output.println(s);	
	}
}
