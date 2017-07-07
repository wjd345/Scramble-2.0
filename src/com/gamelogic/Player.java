/**
 * File Name: Player.java
 * Description: Player object to keep track of name, words, points, etc.
 */

package com.gamelogic;

import java.io.Serializable;
import java.util.Vector;

public class Player implements Serializable {
	
	private String playerName;
	private int playerNumber;
	private int playerWins;
	private int playerLoses;
	private int playerTies;
	private int wordCount;
	private int score;
	private Vector<String> playerWords;
	
	/**
	 * Empty Player for Testing purposes
	 */
	public Player() {
		
		playerName = null;
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
	
	public void namePlayer(String name) {
		playerName = name;
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

	public void playerWon() {
		playerWins += 1;
	}
	/**
	 * @return the playerWins
	 */
	public int getPlayerWins() {
		return playerWins;
	}

	public void playerLost() {
		playerLoses += 1;
	}
	/**
	 * @return the playerLoses
	 */
	public int getPlayerLoses() {
		return playerLoses;
	}
	
	public void playerTied(){
		playerTies += 1;
	}
	
	public int getPlayerTies(){
		return playerTies; 
	}

	public void incrementWordCount(int count) {
		this.wordCount += count;
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
		this.score += score;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	public void clearScore() {
		score = 0;
	}

	/**
	 * Adds word to the players Vector
	 * @param wordList
	 */
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
