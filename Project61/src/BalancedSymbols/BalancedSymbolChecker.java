package BalancedSymbols;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;



/**
 * Starting point for Project 6 , This class is to check the balance of the symbols given in a class
 * 
 * 
 * @author Trevor Conger
 * @version Spring 2021 Version 1
 *
 */
public class BalancedSymbolChecker {
	
	/** String of text containing the code we're parsing */
	private String text;
	

	/**
	 * THis is the constructor for the class to take in the file given
	 * @param filename - This will be the valid or not valid class
	 */
	public BalancedSymbolChecker(String filename){
	

		text = "";
		try{
			BufferedReader bir = new BufferedReader(new FileReader(filename));
			while(bir.ready()) {
				text += bir.readLine() + "\n";
			}	
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + filename);
		}catch (IOException e) {
			System.err.println("Error reading from file: " + e.getMessage());
		}
	}
	/**
	 * This method will be to check balance on the file given, will tell the user if the file is not 
	 * valid and let them know where the error is
	 * @param text This text is the string version of the class and it will iterator through the 
	 * text until it finds an error
	 * @return Will return true if no error, false if it finds an error
	 */
	public static Boolean checkBalance(String text) { //everything can be in this method 
		// 
		Stack<Character> stack = new Stack<Character>();
			try {
		
				for(int i = 0; i < text.length(); i++) {
					Character check  = text.charAt(i);
					System.out.print(text.charAt(i));
					if(text.charAt(i) == '(' || text.charAt(i) == '{' || text.charAt(i) == '[' ) {
						stack.push(check);
							
						}else if(text.charAt(i) == ')') {
							if(!stack.isEmpty() && stack.peek() == '(') {
								stack.pop();
							}else {
								System.out.println("\n Error cannot use " + text.charAt(i) + " to close " +  stack.peek());
								return false;
							}
						}else if(text.charAt(i) == ']') {
							if(!stack.isEmpty() && stack.peek() == '[') {
								stack.pop();

							}else {
								System.out.println("\n Error cannot use " + text.charAt(i) + " to close " +  stack.peek());
								return false;
							}
					
						}else if(text.charAt(i) == '}') {
							if(!stack.isEmpty() && stack.peek() == '{') {
								stack.pop();
							}else {
								System.out.println("\n Error cannot use " + text.charAt(i) + " to close " +  stack.peek());
								return false;
							}
						}
					}System.out.println("!!!!!!!!!! Balanced !!!!!!!!!!!!!!!!");
							
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;	
		}
	/**
	 * Main Method for the class, will use a simple if statement to check if true for the class given
	 * @param args 
	 */
	public static void main(String[] args) {
			BalancedSymbolChecker check = new BalancedSymbolChecker("Valid.java");
			if(checkBalance(check.text));
	}
}

	


	
		
			
			
	