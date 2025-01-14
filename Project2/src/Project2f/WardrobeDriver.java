package Project2f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * COS212 Project 2
 * 
 * 
 * @author Nathan Gossett
 * @author //TODO YOUR NAME HERE 
 * @version 2020
 */

public class WardrobeDriver {
	/** Store the list of clothes in the wardrobe */
	private ArrayList<Apparel> myClothes;
	
	
	/**
	 *  Method to create the ArrayList and populate it
	 */
	public WardrobeDriver() {
		super();
		myClothes = new ArrayList<Apparel>();
	}

	/**
	 * A method to hard-code some example clothes
	 * While loop will continue until the user gives correct information to the computer
	 */
	private void populate(){
		Scanner input = new Scanner(System.in);
		
		//TODO Collect price/color until user supplies valid input
		
		int choice = 1;
		while (choice != 0) {
			try {
				if (choice == 1) {
					System.out.println("How much does the shirt cost?");
					double Price = input.nextDouble();
					input.nextLine();
					System.out.println("What is the color of the shirt?");
					String Color = input.nextLine();
					//input.nextLine();
					Shirt g = new Shirt(Color, Price, Apparel.Condition.GOOD, Shirt.Size.M, "Im with the band");
					myClothes.add(g);
					choice = 0;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				input.nextLine(); 
			}
		}
			
			
		myClothes.add(new Shirt("white", 9.99, Apparel.Condition.POOR, Shirt.Size.M, ""));
		myClothes.add(new Pants("blue", 29.99, Apparel.Condition.NEW, 30, 32));
		myClothes.add(new Pants("black", 39.99, Apparel.Condition.TRASHED, 44, 35));
		myClothes.add(new Pants("khaki", 42.99, Apparel.Condition.GOOD, 40, 38));
		
		//Your Apparel class should implement .<Apparel> interface, which
		//then makes you compatible with this line.  Uncomment it once you've read
		//this.
		//TODO uncomment the line below
		Collections.sort(myClothes);
		}

	/**
	 * Override the default toString to print a list of the clothes
	 * in the wardrobe
	 */
	public String toString(){
		String myString = "";
		for(Apparel a : myClothes){
			myString += a + "\n\n";
		}
		return myString;
	}

	/**
	 * Main method to populate the ArrayList and will print out the sorted Array to the user once they have given the 
	 * correct information
	 * @param args 
	 */
	public static void main(String [] args){
		WardrobeDriver myWardrobe = new WardrobeDriver();
		myWardrobe.populate();
		System.out.print(myWardrobe);
	}
	
}
