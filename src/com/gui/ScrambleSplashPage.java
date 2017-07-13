package com.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ScrambleSplashPage extends JFrame implements Runnable {
	
	
	public JPanel splashPanel;
	public JPanel upper;
	public JPanel lower;
	public JLabel splashLabel;
	public JButton startButton;
	public JButton quitButton;
	private boolean isAlive = true;
	
	private ScrambleGui gameMenu;
	
	
	public ScrambleSplashPage(){
		
		splashPanel = new JPanel();
		splashLabel = new JLabel("SCRAMBLE!");
		startButton = new JButton("Press to Play");
		quitButton = new JButton("Quit");
		upper = new JPanel();
		lower = new JPanel();
		
		lower.setLayout(new BoxLayout(lower,BoxLayout.Y_AXIS));
		
	    lower.setBackground(new Color(250,210,20));
	    upper.setLayout(new BorderLayout());
	    upper.setBackground(new Color(250,210,20));
	    
	    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

	    splashPanel.setVisible(true);
	    splashPanel.setBackground(new Color(250,210,20));//setting background color
	    splashPanel.setLayout(new GridLayout(2,1));
	    Font splashFont = new Font("Sans Serif", Font.BOLD, 70);
	    splashLabel.setFont(splashFont);
	    splashLabel.setHorizontalAlignment(JLabel.CENTER);
	    splashLabel.setVerticalAlignment(JLabel.BOTTOM);
	    
	    startButton.addActionListener(new ActionListener(){

	         public void actionPerformed(ActionEvent e)
	         {
	        	gameMenu = new ScrambleGui();
	        	
	            remove(splashPanel);
	            add(gameMenu,BorderLayout.CENTER);
	            revalidate();
	            repaint();
	            pack();
	            
	         }

	      });
	    
	    quitButton.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		
	    		System.out.println("Thank You For Playing!");
	    		System.exit(0);
	    	}
	    });
	    

	    upper.add(splashLabel,BorderLayout.CENTER);
	    lower.add(startButton);
	    lower.add(quitButton);
	    
	    splashPanel.add(upper);
	    splashPanel.add(lower);
	    
	    splashPanel.setPreferredSize(new Dimension(600,800));
	    
	}
	
	public void run(){
	    
		while(isAlive){
		    add(splashPanel);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    pack();
		    setVisible(true);
		}
	    
	}
	
}
