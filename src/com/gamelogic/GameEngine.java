/**
 * File Name: GameEngine.java
 * Description: Implements the all game logic that is incorporated in
 * the game from scoring to ensuring that the correct player has won the game
 */

package com.gamelogic;

import com.dictionary.Dictionary;
import java.io.*;
import java.nio.*;



public class GameEngine {
	
	private Player playerOne;
	private Player playerTwo;
	private Dictionary dictionary;
	private ObjectInputStream inPlayer;
	private ObjectOutputStream outPlayer;
	
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
	
	

}
