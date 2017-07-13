package com.server;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Vector;


import com.gamelogic.Player;
import com.dictionary.*;

public class ScrambleServer implements Runnable {
	
	//Server I/O
	private ServerSocket serverSocket;
	private ObjectInputStream playerIn;
	private ObjectOutputStream playerOut;
	private Socket player;

	
	// Private Server Variables
	private int serverSession = 0;
	private int playerNumber = 0;
	private boolean isRunning = true;
	private Vector<Player> playerSet;
	private static final int PLAYER_SERVER_MAX = 4;
	
	//Class ServerLog information
	public JFrame frame;
	public JTextArea jtaLog;
	public JScrollPane scrollWindow;
	public Date currentDate;
	
	//Test Dictionary
	public Dictionary testDict;
	

	/**
	 * Constructor that creates the Scramble Server Object;
	 */
	public ScrambleServer(){
		
		frame = new JFrame();
		jtaLog = new JTextArea();
		scrollWindow = new JScrollPane(jtaLog);
		
		frame.add(scrollWindow,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,300);
		frame.setTitle("Scramble Server");
		frame.setVisible(true);
		
		currentDate = new Date();
		
		try{
			
			serverSocket = new ServerSocket(8080,4);
			
			serverSession += 1;
			
			jtaLog.append(currentDate + ": Server Started at socket 8080.\n");
			jtaLog.append("Server Session: " + serverSession + ".\n");
			
			playerSet = new Vector<>(4);
			
			testDict = new Dictionary();
			
		}catch(IOException ioe){
			jtaLog.append("Error in server: " + ioe.getMessage() + ".\n");
		}
		
	}
	

	
	public void closeConnections() throws IOException{
		
		playerIn.close();
		playerOut.close();
		
	}
	
	public void run(){
		
		while(playerNumber < PLAYER_SERVER_MAX){
			try{
				
				player = serverSocket.accept();
				playerNumber += 1;
				
				playerOut = new ObjectOutputStream(player.getOutputStream());
				
				playerIn = new ObjectInputStream(player.getInputStream());
				
				jtaLog.append("Player: " + playerNumber + " on IP Address: " + player.getInetAddress() + ".\n");
				jtaLog.append("Player: " + playerNumber + " joined on: " + currentDate + ".\n");
				
				String playerInformation = "The Player is: " + playerNumber;
				playerOut.writeObject(playerInformation);
				playerOut.flush();
				
				String playerWord = (String)playerIn.readObject();
				
				String wordResult;
				
				if(testDict.contains(playerWord)){
					wordResult = "Word: " + playerWord + " is a Word.";
					jtaLog.append(wordResult + "\n");
				}else{
					wordResult = "Word: " + playerWord + " is not a Word.";
					jtaLog.append(wordResult + "\n");
				}
				
				playerOut.writeObject(wordResult);
				playerOut.flush();
				
				
				
				/*
				if(playerNumber == 0 && !playerTwo.isConnected()){
					playerOne = serverSocket.accept();
					playerNumber += 1;
					
					playerIn = new ObjectInputStream(playerOne.getInputStream());
					Player firstPlayer = (Player)playerIn.readObject();
					
					firstPlayer.setPlayerNumber(playerNumber);
					
					playerSet.add(firstPlayer);
					
					jtaLog.append("Player: " + playerNumber + "has joined Session: " + serverSession);
					
				}else{
					playerTwo = serverSocket.accept();
					playerNumber += 1;
					
					playerIn = new ObjectInputStream(playerTwo.getInputStream());
					Player newPlayerObj = (Player)playerIn.readObject();
					
					newPlayerObj.setPlayerNumber(playerNumber);
					
					playerSet.addElement(newPlayerObj);
					
					jtaLog.append("Player: " + playerNumber + "has joined Session: " + serverSession);
				}*/
			}catch(IOException|ClassNotFoundException ex){
				System.out.println("Error" + ex.getMessage());
			}
			
		}
		
	}
}
