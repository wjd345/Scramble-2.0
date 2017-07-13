package com.server;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Vector;


import com.gamelogic.Player;

public class ScrambleServer implements Runnable {
	
	//Server I/O
	private ServerSocket serverSocket;
	private ObjectInputStream playerIn;
	private ObjectOutputStream playerOut;
	private Socket playerOne;
	private Socket playerTwo;
	
	// Private Server Variables
	private int serverSession = 0;
	private int playerNumber = 0;
	private boolean isRunning = true;
	private Vector<Player> playerSet;
	
	//Class ServerLog information
	public JFrame frame;
	public JTextArea jtaLog;
	public JScrollPane scrollWindow;
	

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
		
		try{
			
			serverSocket = new ServerSocket(8080);
			
			serverSession += 1;
			
			jtaLog.append(new Date() + ": Server Started at socket 8080.\n");
			jtaLog.append("Server Session: " + serverSession + ".\n");
			
			playerSet = new Vector<>(4);
			
		}catch(IOException ioe){
			jtaLog.append("Error in server: " + ioe.getMessage() + ".\n");
		}
		
	}
	

	
	public void closeConnections() throws IOException{
		
		playerIn.close();
		playerOut.close();
		
	}
	
	public void run(){
		
		while(isRunning == true){
			try{
				
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
				}
			}catch(IOException | ClassNotFoundException ex){
				System.out.println("Error" + ex.getMessage());
			}
			
		}
		
	}
}
