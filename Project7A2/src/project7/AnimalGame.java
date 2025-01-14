package project7;

import java.util.Scanner;

public class AnimalGame{

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/**
		 * This is the string for the user input that will be used for the game to see what the user guesses
		 */
		String userInput;
		/**
		 * Instance of AnimalGame,this is to make it viewable in my class
		 */
		AnimalGame myGame = new AnimalGame();
		/**
		 * Tree for the game, this will start with a a question and two answers
		 */
		BTNode<String> tree = myGame.new BTNode<String>("Does it live in the sea?", myGame.new BTNode<String>("Whale", null, null), myGame.new BTNode<String>("Dog", null, null));
		/**
		 * This will keep track of the current position of the tree
		 */
		BTNode<String> current = tree;
		/**
		 * This will be a check to see if the user has won the game or not
		 */
		int winner = 1;
		/**
		 * Method for my game to ask the user questions and print back to user where they are in the tree and if the user
		 * has guesses the correct answer as the computer
		 */
		while(winner != 0) {
			System.out.println("Are you thinking of an animal?  Let's see if I can guess it!");
			
			while(current.getLeft() != null || current.getRight() != null) {
				System.out.println(current.getData()  + " Y/N");
				userInput = input.nextLine();
				if(userInput.charAt(0) == 'Y') { //left = yes
					current = current.getLeft();
				}else if(userInput.charAt(0) == 'N') {
					current = current.getRight();	
				}
			}
			System.out.println("You Were thinking of a " + current.getData() + " (Y/N)");
			userInput = input.nextLine();
			if(userInput.charAt(0) == 'Y') {
				System.out.println("Hurray!");
				winner = 0;
				break;
			}else {
			System.out.println("What animal were you thinking?");
			userInput = input.nextLine();
			current.left = myGame.new BTNode<String>(userInput, null, null);
			System.out.println("Think of a question");
			userInput = input.nextLine();
			current.right = myGame.new BTNode<String>(current.getData(), null, null);
			current.setData(userInput);
			current = tree;
			}
			
		}
	
	}
	/**
	 * BTNode class to handle the nodes we give it
	 * @author Trevor Conger
	 *
	 * @param <T>
	 */
	public class BTNode<T>{

		//attributes
		/**
		 * Attribute to keep track of the data given to the node of type T
		 */
		public T data;  // a ref. to our data
		/**
		 * Attribute for the left node of type BTNode<T>
		 */
		public BTNode<T> left;   // left child node
		/**
		 * Attribute for the right node of type BTNode<T>
		 */
		public BTNode<T> right;  // right child node

		//constructors
		/**
		 * Constructor for the BTNode class
		 * @param data This data will be used for the question asked by the computer
		 * @param left Left node of the tree
		 * @param right Right node of the tree
		 */
		public BTNode(T data, BTNode<T> left, BTNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		/**
		 * Getter method to get data
		 * @return Will return T data 
		 */
		public T getData() {
			return this.data;
		}
		/**
		 * Setter method to set data
		 * @param data of type T
		 */
		public void setData(T data) {
			this.data = data; 
		}
		/**
		 * Getter method to get the left node
		 * @return Return BTNode<T> left node
		 */
		public BTNode<T> getLeft() {
			return this.left;
		}
		/**
		 * Getter method to get the right node
		 * @return Return BTNode<T> right node
		 */
		public BTNode<T> getRight(){
			return this.right;
		}	
	}
}
