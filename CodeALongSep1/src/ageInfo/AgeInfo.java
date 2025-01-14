package ageInfo;

import java.util.Scanner;
/**
 * 
 * @author Trevor Conger
 * Get the age of a user and first name
 */
public class AgeInfo {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int age;
		String firstname;
		System.out.print("Enter your first name and age: ");
		firstname = input.next();
		age = input.nextInt();
		input.nextLine();
		
		System.out.println(firstname + " you are ");
		System.out.print(age*12 + " months old"); 
		
	} //main
	
} // Class AgeInfo
