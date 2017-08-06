package com.gui;


import java.awt.*;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.awt.event.*;



public class ScrambleGui extends JPanel {
	
	// JPanel Variables
	private JTextArea testText;
	private JButton quitButton, serverTestConnection, titleScreen;
	private JTextField testEntry;
	
	// I/O Connections to Server;
	private Socket playerSocket;
	private DataInputStream playerIn;
	private DataOutputStream playerOut;
	private PrintWriter out;
	private int readIn;
	private String playerWords;
	
	public ScrambleGui(){
		
		testText = new JTextArea("Test String");
		testEntry = new JTextField();
		serverTestConnection = new JButton("Connect to Server");
		titleScreen = new JButton("TitleScreen");
		quitButton = new JButton("Quit");
		JPanel buttonPanel = new JPanel();
		
		setPreferredSize(new Dimension(600,800));
		//setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setLayout(new GridLayout(3,1));
		
		testText.setAlignmentX(Component.CENTER_ALIGNMENT);
		testEntry.setBorder(BorderFactory.createEmptyBorder(10, 20, 5,20));
		testEntry.setFocusable(true);
		testEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		serverTestConnection.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		testEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String userEntry = testEntry.getText().toLowerCase();
				
				try{
					playerOut.writeUTF(userEntry);
					playerOut.flush();
					testEntry.setText("");
					playerWords = playerIn.readUTF();
					testText.setText(playerWords);
				}catch(IOException ioe){
					System.err.println("Error-" + ioe.getMessage());
				}

			}
		});
		
		serverTestConnection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					serverConnection();
					readIn = playerIn.read();
					testText.setText("Player Number" + readIn);
					serverTestConnection.setVisible(false);
				}catch(IOException ioe){
					System.out.println("Error-" + ioe.getMessage());
				}
			
			}
		});
		
		
	    quitButton.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		System.out.println("Thank you for playing!");
	    		System.exit(0);
	    	}
	    });
	    
		add(testEntry);
		add(testText);
		buttonPanel.add(serverTestConnection);
		buttonPanel.add(quitButton);
		add(buttonPanel);
		
		setBackground(new Color(250,210,20));
		
		setVisible(true);
	    
		
	}
	
	private void serverConnection() throws IOException{
		playerSocket = new Socket("localhost",8080);
		playerIn = new DataInputStream(playerSocket.getInputStream());
		playerOut = new DataOutputStream(playerSocket.getOutputStream());
		out = new PrintWriter(new OutputStreamWriter(playerSocket.getOutputStream()));
		System.out.println("Connection Successful...");
	}
	
	private void closeConnections() throws IOException{
		playerOut.close();
		playerIn.close();
		playerSocket.close();
		System.out.println("Successfully closed connections...");
	}
	
}
