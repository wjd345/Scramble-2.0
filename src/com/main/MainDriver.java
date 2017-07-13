/**
 * File Name: MainDriver.java
 * Description: Test and main implementation of the Scramble 2.0 game
 * 
 */
package com.main;

import com.dictionary.Dictionary;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import com.gui.ScrambleSplashPage;
public class MainDriver {
	
	
	public static void main(String[] args) {
		
		ScrambleSplashPage splashPage = new ScrambleSplashPage();
		new Thread(splashPage).start();
		/**
		try {
			Dictionary dictionary = new Dictionary();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			
			System.out.println("Please Enter in a Valid Word: ");
			
			while(!(userInput = input.readLine()).equalsIgnoreCase("q")) {
				
				if(!dictionary.contains(userInput)){
					System.out.println("Sorry word does not exist");
				}else {
					System.out.printf("Congrats the word: %s exists!\n",userInput);
				}
				
				System.out.println("Would you like to quit?");
				System.out.println("Enter Q to quit or another word to continue: ");
				
			}
			
			System.out.println("Thank You!");
			System.out.println("GoodBye");
			input.close();
			
			System.exit(0);
			
		}catch(IOException ioe) {
			System.err.println("There was an Error reading the file!");
			ioe.printStackTrace();
		}*/
	}
}
