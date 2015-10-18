package com.exercise.game;

import com.exercise.game.CardShufflerFactory.ShuffleType;
import com.exercise.game.RuledBasedFactory.GameType;


public class GameParamHolder implements HolderInf<Integer,ShuffleType, GameType > {
	
	private int numberOfPlayers;
	private ShuffleType shuffleType;
	private GameType gameType;

	@Override
	public Integer getPlayerNumber() {
		return numberOfPlayers;
	}

	@Override
	public ShuffleType getShuffler() {
		return shuffleType;
	}

	@Override
	public GameType getGameType() {
	  return gameType;
	}

	@Override
	public void popluateHolder(Integer n, ShuffleType s, GameType g) {
		this.numberOfPlayers = n;
		this.shuffleType = s;
		this.gameType = g;
	}
	
	

}
