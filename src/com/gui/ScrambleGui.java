package com.gui;


import java.awt.*;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.awt.event.*;



public class ScrambleGui extends JPanel implements Serializable {
	
	// JPanel Variables
	private JTextArea testText;
	private JButton quitButton, serverTestConnection;
	private JTextField testEntry;
	private Socket playerConnection;
	
	// I/O Connections to Server;
	private Socket playerSocket;
	private ObjectInputStream playerIn;
	private ObjectOutputStream playerOut;
	private String readIn;
	
	public ScrambleGui(){
		
		
		testText = new JTextArea("Test String");
		testEntry = new JTextField();
		serverTestConnection = new JButton("Connect to Server");
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
				
				try{
					playerOut.writeObject(text);
					playerOut.flush();
					
					String serverText = (String)playerIn.readObject();
					testText.setText(serverText);
					
				}catch(IOException | ClassNotFoundException ioe){
					System.out.println("Error: " + ioe.getMessage());
					ioe.printStackTrace();
				}
				
				testEntry.setText("");
			}
		});
		
		serverTestConnection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					serverConnection();
					readIn = (String)playerIn.readObject();
					testText.setText(readIn);
					if(playerSocket.isConnected()){
						serverTestConnection.setVisible(false);
						
					}
				}catch(IOException | ClassNotFoundException ioe){
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
		playerIn = new ObjectInputStream(playerSocket.getInputStream());
		playerOut = new ObjectOutputStream(playerSocket.getOutputStream());
	}
	
}
