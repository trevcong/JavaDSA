package arrayReview;
import java.util.Random;

/**
 * Reviewing working with Arrays
 * @author gosnat/albing
 * @author Trevor Conger
 * @version Fall 2021
 *
 */
public class Table {
	
	/** The actual 2D array of values */
	private int[][] values;
	
	
	
	/**
	 * Fill this in to determine whether this object is equivalent to the
	 * object being passed in as a paramter
	 * Rules:
	 * 1) If otherObject isn't even a Table object, not equal
	 * 2) If this Table and the other table have different dimensions, not equal(  .length[0] 
	 * 3) If this Table and the other Table have different values, not equal DFL 
	 * this.values otherTable.values.length[0] 
	 */
	@Override
	public boolean equals(Object otherObject) {
		
		
		// )1
		if(otherObject instanceof Table == false) {
			return false;
		}

		// )2
		Table otherTable = (Table) otherObject; //if both zero dimensions, row and colm, then should be equal

		// )3
		
		if(values.length != otherTable.values.length) { 
			return false;
		}
		
		for(int i = 0; i < otherTable.values.length; i++) {
			if(values[i].length != otherTable.values[i].length) {
				return false;
			}
			for(int j = 0; j < otherTable.values[i].length; j++) {
				if(values[i][j] != otherTable.values[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * @return the smallest value stored in this table
	 * @throws IllegalStateException if zero dimension(s)
	 */
	public int smallestValue() throws IllegalStateException{
		if(values.length == 0 || values[0].length == 0) {
			throw new IllegalStateException("You tried to find a zero dimension");
		}
		
		int small = Integer.MAX_VALUE; 
		for(int i = 0; i < values.length; i++) {
			for(int j = 0; j < values[0].length; j++) {
				if(values[i][j] < small) {
					small = values[i][j];
				}
			}
		}
		return small;
	}
	
	/**
	 * Alter the value at the specified coordinates
	 * @param number the new value to store at that location
	 * @param row the row where you want to make the change
	 * @param col the column where you want to make the change
	 * @throws IllegalArgumentException if coordinates are not a valid location
	 */
	public void setValueAt(int number, int row, int col) throws IllegalArgumentException {
		try {
			values[row][col] = number;
		}catch(Exception b) {
			throw new IllegalArgumentException("Illegal cordinated in location");
		}
	}
	
	/**
	 * A constructor that populates array based on "random" number seed
	 * @param rows the row count of the 2D array
	 * @param cols the column count of the 2D array
	 * @param seed the seed value for the psuedo-random number generator
	 * 		(ensures we get the same set of values each time)
	 */
	public Table(int rows, int cols, int seed) {
		Random rGen = new Random(seed);
		values = new int[rows][cols];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				values[r][c] = rGen.nextInt(101) - 50; //random value between -50 and 50
			}
		}
	}
	
	/**
	 * A second (overloaded) constructor where all values are manually supplied
	 * @param data
	 */
	public Table(int[][] data) {
		values = data.clone(); //Should result in deep copy for Java primitive arrays
	}

} // class Table