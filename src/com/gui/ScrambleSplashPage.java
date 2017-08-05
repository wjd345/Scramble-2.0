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
	private Color bgColor = new Color(250,210,20);
	private CardLayout cLayout;
	private JPanel[] cardPanels;
	private ScrambleGui gameMenu;
	
	
	public ScrambleSplashPage(){
		super("Scramble Splash Page");
		
		splashPanel = new JPanel();
		splashLabel = new JLabel("SCRAMBLE!");
		startButton = new JButton("Press to Play");
		quitButton = new JButton("Quit");
		cardPanels = new JPanel[4];
		cLayout = new CardLayout();
		constraints = new GridBagConstraints();
		lower = new JPanel();
		lower.setBackground(bgColor);
		//lower.setLayout(new BorderLayout());

	    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


	    splashPanel.setBackground(bgColor);//setting background color
	    //splashPanel.setLayout(new BorderLayout());
	    splashPanel.setLayout(new GridLayout(2,1));
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
	            setTitle("Scramble!!!");
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
	    

	    splashPanel.add(splashLabel);
	    lower.add(startButton);
	    lower.add(quitButton);
	    splashPanel.add(lower);
	    
	    
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
