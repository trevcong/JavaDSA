package BalancedSymbols;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;



/**
 * Starting point for Project 6
 * 
 * 
 * @author Nathan Gossett
 * @version Spring 2021
 *
 */
public class BalancedSymbolChecker {
	
	/** String of text containing the code we're parsing */
	private String text;
	
	//private Stack<Character> stack;
	
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
	
	public static Boolean checkBalance(String text) { //everything can be in this method 
		// 
		Stack<Character> stack = new Stack<Character>();
			try {
		
				for(int i = 0; i < text.length(); i++) {
					Character check  = text.charAt(i);
					System.out.println(text.charAt(i));
					if(text.charAt(i) == '(' || text.charAt(i) == '{' || text.charAt(i) == '[' ) {
						stack.push(check);
							
						}else if(text.charAt(i) == ')') {
							if(!stack.isEmpty() && stack.peek() == '(') {
								stack.pop();
							}else {
								System.out.println("Error cannot use " + text.charAt(i) + " to close (");
								return false;
							}
						}else if(text.charAt(i) == ']') {
							if(!stack.isEmpty() && stack.peek() == '[') {
								stack.pop();
							}else {
								System.out.println("Error cannot use " + text.charAt(i) + " to close [");
								return false;
							}
					
						}else if(text.charAt(i) == '{') {
							if(!stack.isEmpty() && stack.peek() == '}') {
								stack.pop();
							}else {
								System.out.println("Error cannot use " + text.charAt(i) + " to close {");
								return false;
							}
						}
						if(stack.isEmpty()) {
							System.out.println("!!!!!!!!!! Balanced !!!!!!!!!!!!!!!!");
							return true;
						}else {
							return false;
						}
					}
							
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;	
		}
	
	public static void main(String[] args) {
	
			BalancedSymbolChecker check = new BalancedSymbolChecker("ValidClass.java");
			if(checkBalance(check.text));
		
		
	}
}

	


	
		
			
			
			
			
			
	
