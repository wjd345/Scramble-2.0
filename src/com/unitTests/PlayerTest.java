package com.unitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gamelogic.*;
import com.dictionary.*;

import java.util.Vector;

public class PlayerTest {
	
	private Player testP1;
	private Player testP2;
	private Player testP3;
	private Player testP4;
	private Dictionary dictionary;
	private Vector<String> testWordList;
	private GameEngine testEngine;

	@Before
	public void setUp() throws Exception {
		 testP1 = new Player();
		 testP2 = new Player("Tony Stark", 1);
		 testP3 = new Player("Bruce Banner",2);
		 testP4 = new Player("Steven Strange", 1);
		 dictionary = new Dictionary();
		 testWordList = new Vector<>();
		 testEngine = null;
	}

	@After
	public void tearDown() throws Exception {
		
		testP1 = null;
		testP2 = null;
		testP3 = null;
		testP4 = null;
		dictionary = null;
		testWordList = null;
		testEngine = null;
		
	}

	@Test
	public void isAPlayerTest() {
		
		assertTrue(testP1.getPlayerName() == null);
		
		testP1.namePlayer("Steve Rogers");
		
		assertFalse(testP1.getPlayerName() == null);
		
		testP1.namePlayer(null);
		
		assertNull(testP1.getPlayerName());
		
		assertNotSame(testP1.getPlayerNumber(),testP2.getPlayerNumber());
		assertNotEquals("Player is not player One",testP1.getPlayerNumber(),1);
		
		assertNull(testP1.getPlayerWords());
		
	}
	
	@Test
	public void areWeScoringPlayersTest() {
		
		testP2.setScore(1000);
		testP3.setScore(2000);
		
		assertTrue(testP2.getScore() < testP3.getScore());
		
		testP2.clearScore();
		testP3.clearScore();
		
		assertEquals(testP2.getScore(), testP3.getScore());
		
	}
	
	@Test
	public void isThereAWinnerTest() {
		
		testWordList.add("pineapple");
		testWordList.add("bacon");
		
		testP2.addWords(testWordList);
		
		testWordList.add("turtle");
		testWordList.add("mouse");
		
		testP3.addWords(testWordList);
		testEngine = new GameEngine(testP2,testP3);
		
		testEngine.scorePlayer(testP2);
		testEngine.scorePlayer(testP3);
		
		testEngine.gameResult();
		
		
		
	}
	

}
