/**
 * File Name: Player.java
 * Description: Player object to keep track of name, words, points, etc.
 */

package com.gamelogic;

import java.io.Serializable;
import java.util.Vector;

public class Player implements Serializable {
	
	public String playerName;
	public int playerNumber;
	public int playerWins;
	public int playerLoses;
	public int playerTies;
	public int wordCount;
	public int score;
	private Vector<String> playerWords;
	
	/**
	 * Empty Player for Testing purposes
	 */
	public Player() {
		playerNumber = 0;
		playerWins = 0;
		playerLoses = 0;
		playerTies = 0;
		wordCount = 0;
		score = 0;
		
		playerWords = new Vector<>();
	}
	
	/**
	 * Constructor for a real player
	 * @param name
	 * @param number
	 * @param words
	 */
	public Player(String name, int number) {
		
		playerName = name;
		playerNumber = number;
		playerWins = 0;
		playerLoses = 0;
		playerTies = 0;
		wordCount = 0;
		score = 0;
		
		playerWords = new Vector<>();
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @return the playerWins
	 */
	public int getPlayerWins() {
		return playerWins;
	}

	/**
	 * @return the playerLoses
	 */
	public int getPlayerLoses() {
		return playerLoses;
	}

	/**
	 * @return the playerTies
	 */
	public int getPlayerTies() {
		return playerTies;
	}

	/**
	 * @return the wordCount
	 */
	public int getWordCount() {
		wordCount = playerWords.size();
		return wordCount;
	}
	
	/**
	 * Sets score from the game logic class
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	
	public void addWords(Vector<String> wordList){
		if(wordList != null) {
			playerWords = wordList;
		}
	}
	/**
	 * @return the playerWords
	 */
	public Vector<String> getPlayerWords() {
		return playerWords;
	}

	
	
	
}
