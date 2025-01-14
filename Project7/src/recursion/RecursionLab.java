package recursion;

/**rei
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
	 */b
	public static long rec_C(int N, int k) {
		
		if(k > N) 
			throw new IllegalArgumentException();
		if(k < 0) 
			throw new IllegalArgumentException();
		
		return rec_C(N - 1, k - 1) + rec_C(N - 1, k);
		
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
		
		for(int i = 0; i < binNumber.length(); i++) {
		if(binNumber.charAt(i) != '0' && binNumber.charAt(i) != '1') {
			throw new IllegalArgumentException();
			}
		}
		if(binNumber.length() > 31) {
			throw new IllegalArgumentException();
		}
		
		int decimal1 = 0;
		int lengthOfNum = binNumber.length();
		if(lengthOfNum > 0) {
			String sub = binNumber.substring(1);
			int first = Character.getNumericValue(binNumber.charAt(0));
			decimal1 = first * (int) Math.pow(2, lengthOfNum - 1) + binToDec(sub);
		}
		
		return decimal1;
	}



}