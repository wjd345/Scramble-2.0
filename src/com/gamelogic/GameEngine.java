/**
 * File Name: GameEngine.java
 * Description: Implements the all game logic that is incorporated in
 * the game from scoring to ensuring that the correct player has won the game
 */

package com.gamelogic;

import com.dictionary.Dictionary;

public class GameEngine {
	
	private Player playerOne;
	private Player playerTwo;
	
	/**
	 * Constructor that takes in two player objects for the game play
	 * @param p1
	 * @param p2
	 */
	public GameEngine(Player p1, Player p2) {
		playerOne = p1;
		playerTwo = p2;
	}

}
