package project7;

import java.util.Scanner;

import project7.BinaryTree.BTNode;

public class AnimalGame {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String userInput;
		
		BinaryTree<String> tree = new BinaryTree<String>("Does it live in the sea?", new BTNode<String>("Whale", null, null), new BTNode<String>("Dog", null, null));
		
		BTNode<String> current = tree.getRoot();
	
		
		int winner = 1;
		
		int nextstep = 1; 
		
		while(winner != 0) {
			System.out.println("Are you thinking of an animal?  Let's see if I can guess it!");
			
			while(current.getLeft() != null || current.getRight() != null) {
				System.out.println(current.getData()  + " Y/N");
				userInput = input.nextLine();
				
				if(userInput == "Y") { //left = yes
					System.out.println("Hurray!");
					winner = 0;
				}else if(userInput == "N") {
					current = current.getRight();
					BTNode<String> right = new BTNode<String>(current.getRight());
					System.out.println("You were thinking of a" + tree.getRight().getData());
					nextstep = 0;
					
				}
			}
			if(nextstep == 0) {
			System.out.println("What animal were you thinking?");
			userInput = input.nextLine();
			current.addNodeLeft(userInput);
			System.out.println("Think of a question");
			userInput = input.nextLine();
			current.addNodeRight(current.getData());
			current.setData(userInput);
			nextstep = 1;
			
			}
		
		}
		
		
		/**
		 * BinaryTree<String> current = root;
		while() {
			while(current.next != null) {
				
				//while current.next != null
				//ask questions and get user input
				 // Current.data 
				  //user input = Y/N  
				   if(N) current = current.right;
				   else current = current.left;
			}
			//What animal
			//User says animal
			// set data of currernt.right.data = animal
			//User gives question , this will set the current.data = question
		}
		**/
		
		
		
		
		
		
		
		
		
		
	
	}
	
	
	
}
