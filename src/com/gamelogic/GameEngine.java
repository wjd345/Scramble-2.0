/**
 * File Name: GameEngine.java
 * Description: Implements the all game logic that is incorporated in
 * the game from scoring to ensuring that the correct player has won the game
 */

package com.gamelogic;

import com.dictionary.Dictionary;
import java.io.*;
import java.nio.*;
import java.util.Vector;


public class GameEngine implements Runnable {
	
	private Player playerOne;
	private Player playerTwo;
	private Dictionary dictionary;
	private ObjectOutputStream outPlayerInfo;
	
	/**
	 * Constructor that takes in a single player for game play.
	 * @param p1
	 */
	public GameEngine(Player p1) {
		playerOne = p1;
		try {
			dictionary = new Dictionary();
		}catch(IOException ioe) {
			System.err.println("Error - Unable to find Dictionary File");
			System.exit(0);
		}
	}
	
	/**
	 * Constructor that takes in two player objects for the game play
	 * @param p1
	 * @param p2
	 */
	public GameEngine(Player p1, Player p2) {
		playerOne = p1;
		playerTwo = p2;
		
		try {
			dictionary = new Dictionary();
		}catch(IOException ioe) {
			System.err.println("Error - Unable to find Dictionary File");
			System.exit(0);
		}
	}
	
	/**
	 * Takes in a Player Object and assess the 
	 * @param player
	 */
	public void scorePlayer(Player player) {
		
		Vector<String> playerWords = player.getPlayerWords();
		
		for(String word: playerWords) {
			if(isValidWord(word)) {
				player.setScore(word.length());
				
			}else {
				player.setScore(0);
			}
		}
	}
	
	/**
	 * Checks to make sure that the word is in the Dictionary
	 * @param word
	 * @return
	 */
	private boolean isValidWord(String word) {
		if(!dictionary.contains(word)) {
			return false;
		}else {
			return true;
		}
	}
	
	public void gameResult(){
		
		int playerOneScore = playerOne.getScore();
		int playerTwoScore = playerTwo.getScore();
		
		if(playerOneScore > playerTwoScore) {
			playerOne.playerWon();
			playerTwo.playerLost();
		}else if(playerOneScore < playerTwoScore) {
			playerTwo.playerWon();
			playerOne.playerLost();
		}
		
	}
	
	public void run() {
		//TODO: Implement runnable
	}
	

}
