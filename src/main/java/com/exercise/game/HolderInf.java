package com.exercise.game;

public interface HolderInf<N,S,G> {
	
	N getPlayerNumber();
	S getShuffler();
	G getGameType();
	
	void popluateHolder(N n, S s, G g);

}
