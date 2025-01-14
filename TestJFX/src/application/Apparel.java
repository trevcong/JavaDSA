package application;
/**
 * Apparel class will be the parent class for the information 
 */
/**
 * Class for apparel, this class is abstract and has the Comparable interface
 * Will be used to take in information from the driver and user input and convey it back to the user
 * @author Trevor Conger
 *
 */
public abstract class Apparel implements Comparable<Apparel>{
/**
 * A color variable of type String
 */
	private String Color;
/**
 * A Price variable of type Double	
 */
	private double Price;
/**
 * A Condition object for the condition of the item of type Project2f.Arrapel.Condition	
 */
	private Condition Condition;
/**
 * A constructor to take information and replay back an exception if there is a problem	
 * @param newColor Color of the item
 * @param newPrice The price of the item
 * @param newCondition Condition of the item
 * @param x X is the size of the item
 * @param string String is the string for the shirt text
 */
	public Apparel(String newColor, double newPrice, Condition newCondition) {
			setColor(newColor);
			setPrice(newPrice);
			setCondition(newCondition);
	}
/**
 * Getter method to get the color of the item	
 * @return Will return the color of the object
 */
	public String getColor() {
		return Color;
	}
/**
 * Setter method that will set the color of the shirt if a correct string is provided	
 * @param newColor Color of shirt provided by the user
 * @throws IllegalArgumentException Will throw and exception if the user gives a NULL or emptry string as the param
 */
	public void setColor(String newColor) throws  IllegalArgumentException {
		if(newColor == null || newColor.equals("")) {
			throw new IllegalArgumentException("Color can't be null or empty");
		}
		this.Color = newColor;
	}
/**
 * Getter method for the price 	
 * @return Will return the price to the user if called
 */
	public double getPrice() {
		return Price;
	}
/**
 * Setter method for the price of the item	
 * @param newPrice Will take in the price from the user
 * @throws IllegalArgumentException Will not accept item that are less than 0$
 */
	public void setPrice(double newPrice) throws  IllegalArgumentException{
		if(newPrice < 0) {
			throw new IllegalArgumentException("Price can't be negative");
		}
		this.Price = newPrice;
	}
/**
 * Getter method for the Condition of the item	
 * @return Will return the condition of the item 
 */
	public Condition getCondition() {
		return Condition;
	}
/**
 * Setter method for the condition of the item	
 * @param newCondition Will take in a condition from the user
 */
	public void setCondition(Condition newCondition) throws IllegalArgumentException{
		if(newCondition == null) {
			throw new IllegalArgumentException("Condition cant be null");
		}
		this.Condition = newCondition;
	}
/**
 * Enum method to make sure	the user provides a correct condition 
 *
 */
	public enum Condition{
		NEW("new"),
		GOOD("good"),
		POOR("poor"),
		TRASHED("trashed");
		private final String mCond;
		Condition(String cond){
			mCond = cond;
		}
		public String toString() { return mCond; }
	}
/**
 * CompareTo method that will compare user inputs and sort them accordingly	
 */
	@Override
	public int compareTo(Apparel other){
		
		
		int holder;
		if(Condition.toString().equals("new"))
			holder = 1;
		else if(Condition.toString().equals("good"))
			holder = 2;
		else if(Condition.toString().equals("poor"))
			holder = 3;
		else if(Condition.toString().equals("trashed"))
			holder = 4;
		else 
			holder = 5;
		
		
		int oa;
		if(other.Condition.toString().equals("new"))
			oa = 1;
		else if(other.Condition.toString().equals("good"))
			oa = 2;
		else if(other.Condition.toString().equals("poor"))
			oa = 3;
		else if(other.Condition.toString().equals("trashed"))
			oa = 4;
		else
			oa = 5;
		
		
		if(holder < oa)
			return -1;
		else if(holder > oa)
			return 1;
		else if (Price < other.getPrice())
			return -1;
		else if (Price > other.getPrice())
			return 1;
		else 
			return 0;
	
	}
	
}