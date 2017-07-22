package com.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ScrambleSplashPage extends JFrame implements Runnable {
	
	
	private JPanel splashPanel;
	private JPanel upper;
	private JPanel lower;
	private JLabel splashLabel;
	private JButton startButton;
	private JButton quitButton;
	private GridBagConstraints constraints;
	private boolean isAlive = true;
	
	private ScrambleGui gameMenu;
	
	
	public ScrambleSplashPage(){
		
		splashPanel = new JPanel();
		splashLabel = new JLabel("SCRAMBLE!");
		startButton = new JButton("Press to Play");
		quitButton = new JButton("Quit");
		constraints = new GridBagConstraints();

	    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


	    splashPanel.setBackground(new Color(250,210,20));//setting background color
	    splashPanel.setLayout(new BorderLayout());
	    splashPanel.setLayout(new GridBagLayout());
	    Font splashFont = new Font("Sans Serif", Font.BOLD, 70);
	    splashLabel.setFont(splashFont);
	    splashLabel.setHorizontalAlignment(JLabel.CENTER);
	    splashLabel.setVerticalAlignment(JLabel.BOTTOM);
	    
	    //startButton.setPreferredSize(new Dimension(100,100));
	    
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
	    
	    constraints.gridwidth = 3;
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.anchor = GridBagConstraints.CENTER;
	    splashLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	    splashPanel.add(splashLabel,constraints);
	    
	   // constraints.gridwidth = 1;
	    //constraints.fill = GridBagConstraints.SOUTH;
	    constraints.anchor = GridBagConstraints.NORTH;
	    splashPanel.add(startButton, constraints);
	    
	    //constraints.gridwidth = 1;
	    constraints.anchor = GridBagConstraints.SOUTH;
	    
	    splashPanel.add(quitButton, constraints);
	    
	    //splashPanel.add(startButton);
	    
	    splashPanel.setPreferredSize(new Dimension(600,800));
	    
	    
	}
	
	public void createGui(){
		
	    add(splashPanel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setContentPane(this.getContentPane());
	    pack();
	    setVisible(true);
		
	}
	
	public void run(){
	    
		createGui();
	    
	}
	
	public static void main(String[] args){
		ScrambleSplashPage spp = new ScrambleSplashPage();
		new Thread(spp).start();
	}
	
}
