package recursion;

/**
 * Template for recursion Lab Remember: NO LOOPING ALLOWED FOR THIS ASSIGNMENT
 * 
 * @author Nathan Gossett
 * @author Your Name Here
 * @version Fall 2020
 *
 */
public class RecursionLab {
	
	/**
	 * Implement this method for part 1 of the assignment 
	 * Plain recursive calculation of binomial coefficients
	 * 
	 * @param N
	 * @param k
	 * @return The number of ways to choose k items from a set of N items
	 * @throws IllegalArgumentException if k > N or k is negative
	 */
	public static long rec_C(int N, int k) {
		//TODO delete the return statement below and implement this method
		return -1;
	}

	/**
	 * Implement this method for part 2 of the assignment 
	 * Recursive method to find decimal equivalent of binary number
	 * 
	 * @param binNumber An String of 0s and 1s representing a binary number
	 * @return The decimal equivalent of input string
	 * @throws IllegalArgumentException if input string is more than 31 bits or if
	 *                                  any 'bit' is something other than a '0' or
	 *                                  '1'
	 */
	public static int binToDec(String binNumber) throws IllegalArgumentException {
		if(binNumber == "1")
			return 1;
		else if(binNumber % "2" == 0)
			return printBinary(binNumber / "2") + "0";
		else return printBinary(binNumber /2) + "1";
	}



}