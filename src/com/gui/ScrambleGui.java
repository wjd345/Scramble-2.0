package com.gui;


import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Random;


public class ScrambleGui extends JPanel implements Serializable, Runnable {
	
	
	private JPanel scramblePanel;
	private JTextArea testText;
	private JButton quitButton;
	
	public ScrambleGui(){
		
		scramblePanel = new JPanel();
		
		testText = new JTextArea("Test String");
		quitButton = new JButton("Quit");
		
		scramblePanel.setPreferredSize(new Dimension(600,800));
		scramblePanel.setLayout(new BorderLayout());
		
		scramblePanel.add(testText, BorderLayout.PAGE_START);
		scramblePanel.add(quitButton, BorderLayout.PAGE_END);
		
		scramblePanel.setVisible(true);
		
	    quitButton.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		
	    		System.out.println("Thank You For Playing!");
	    		System.exit(0);
	    	}
	    });
		
	}
	
	public void run(){
		System.out.println("Test GUI is Working");
	}

}
