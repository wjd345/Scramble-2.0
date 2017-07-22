package com.gui;


import java.awt.*;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.awt.event.*;



public class ScrambleGui extends JPanel implements Serializable {
	
	// JPanel Variables
	private JTextArea testText;
	private JButton quitButton, serverTestConnection, titleScreen;
	private JTextField testEntry;
	private Socket playerConnection;
	
	// I/O Connections to Server;
	private Socket playerSocket;
	private BufferedReader playerIn;
	private BufferedWriter playerOut;
	private PrintWriter out;
	private int readIn;
	private String playerWords;
	
	
	public ScrambleGui(){
		
		
		testText = new JTextArea("Test String");
		testEntry = new JTextField();
		serverTestConnection = new JButton("Connect to Server");
		titleScreen = new JButton("TitleScreen");
		quitButton = new JButton("Quit");
		
		setPreferredSize(new Dimension(600,800));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		testText.setAlignmentX(Component.CENTER_ALIGNMENT);
		testEntry.setBorder(BorderFactory.createEmptyBorder(10, 20, 5,20));
		testEntry.setFocusable(true);
		testEntry.setBorder(BorderFactory.createLineBorder(Color.black));
		serverTestConnection.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(testEntry);
		add(testText);
		add(serverTestConnection);
		add(quitButton);
		
		setBackground(new Color(250,210,20));
		
		setVisible(true);
		
		
		
		testEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
	
				String text = testEntry.getText();
				
				System.out.println(text);
				try{
					playerOut.write(testEntry.getText());
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

				}catch(IOException ioe){
					System.out.println("Error-" + ioe.getMessage());
				}
				
				
			}
		});
		
		
	    quitButton.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		
	    		System.out.println("Thank You For Playing!");
	    		System.exit(0);
	    	}
	    });
	    
		
	}
	
	private void serverConnection() throws IOException{
		playerSocket = new Socket("localhost",8080);
		playerIn = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
		playerOut = new BufferedWriter(new OutputStreamWriter(playerSocket.getOutputStream()));
		out = new PrintWriter(new OutputStreamWriter(playerSocket.getOutputStream()));
	}
	
	private void closeConnections() throws IOException{
		playerOut.close();
		playerIn.close();
		playerSocket.close();
	}
	
}
