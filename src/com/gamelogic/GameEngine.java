/**
 * File Name: GameEngine.java
 * Description: Implements the all game logic that is incorporated in
 * the game from scoring to ensuring that the correct player has won the game
 */

package com.gamelogic;

import com.dictionary.Dictionary;
import java.io.*;
import java.net.*;
import java.util.Vector;


public class GameEngine implements Runnable {
	
	private Player playerOne;
	private Player playerTwo;
	private Socket playerSocket;
	
	private DataInputStream playerIn;
	private DataOutputStream playerOut;
	
	private Dictionary dictionary;
	private Vector<Player> outPlayers = new Vector<>();
	
	private String playerWord;
	private String wordResult;
	
	private int playerScore = 0;
	
	public GameEngine(Socket playerSocket){
		this.playerSocket = playerSocket;
		try{
			dictionary = new Dictionary();
			
			playerIn = new DataInputStream(this.playerSocket.getInputStream());
			playerOut = new DataOutputStream(this.playerSocket.getOutputStream());
			
		}catch(IOException ioe){
			System.out.println("Error: " + ioe.getMessage());
		}
	}
	
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
	public void scorePlayers() {
		
		Vector<String> playerOneWords = playerOne.getPlayerWords();
		Vector<String> playerTwoWords = playerTwo.getPlayerWords();
		
		for(String word: playerOneWords) {
			if(isValidWord(word)) {
				playerOne.setScore(word.length());
				playerOne.incrementWordCount(1);
				
			}else {
				playerOne.setScore(0);
				playerOne.incrementWordCount(0);
			}
		}
		
		for(String word: playerTwoWords) {
			if(isValidWord(word)) {
				playerTwo.setScore(word.length());
				playerTwo.incrementWordCount(1);
				
			}else {
				playerTwo.setScore(0);
				playerTwo.incrementWordCount(0);
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
		}else{
			if(playerOne.getWordCount() > playerTwo.getWordCount()){
				playerOne.playerWon();
				playerTwo.playerLost();
			}else if(playerOne.getWordCount() < playerTwo.getWordCount()){
				playerTwo.playerWon();
				playerOne.playerLost();
			}else{
				int playerOneAdjustedScore = playerOne.getScore() + playerOne.getWordCount();
				int playerTwoAdjustedScore = playerTwo.getScore() + playerTwo.getWordCount();
				
				if(playerOneAdjustedScore > playerTwoAdjustedScore){
					playerOne.playerWon();
					playerTwo.playerLost();
				}else if(playerOneAdjustedScore < playerTwoAdjustedScore){
					playerTwo.playerWon();
					playerOne.playerLost();
				}else{
					playerOne.playerTied();
					playerTwo.playerTied();
				}
			}
		}
		
	}
	
	public Vector<Player> getPlayers(){
		return outPlayers;
	}
	
	public void scoreWord(String word){
		if(dictionary.contains(word)){
			playerScore += word.length();
		}else{
			playerScore += 0;
		}
	}
	
	@Override
	public void run() {
		//TODO: Implement runnable
		try{
			while((playerWord = playerIn.readUTF()) != null){
				if(dictionary.contains(playerWord)){
					scoreWord(playerWord);
					wordResult = "Word: " + playerWord + " is a Word. Score is: " + playerScore;
				}else{
					scoreWord(playerWord);
					wordResult = "Word: " + playerWord + " is not a Word. Score is: " + playerScore;
				}
				
				playerOut.writeUTF(wordResult);
				playerOut.flush();
			}
		}catch(IOException ioe){
			System.out.println("Error: " + ioe.getMessage());
		}
	}
	
}
