package com.exercise.game;

import java.util.List;

public interface RuleBasedInf<P,D, B,O,S> {
	
	public B applyRule(List<P> ps, D d,  LoggerInf<O, S> logger);
	
	public P getWinner(List<P> ps, LoggerInf<O, S> logger );
	
}
