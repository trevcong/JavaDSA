package Project1;
/**
 * Apparel class will be the parent class for the information 
 */
import Project1.Shirt.Size;

public abstract class Apparel {
	/**
	 * Attribute for the color of the cloths
	 */
	private String Color;
	/**
	 * Attribute for the price of the clothing
	 */
	private double Price;
	/**
	 * Attribute for the condition of the clothing
	 */
	private Project1.Apparel.Condition Condition;
	/**
	 * Constructor for the apparel class
	 * @param newColor Color of the clothing
	 * @param newPrice Price of the clothing
	 * @param newCondition Condition of the clothing
	 * @param x x is the size of the clothing
	 * @param string This string will serve as the text on a shirt if needed
	 */
	public Apparel(String newColor, double newPrice, Condition newCondition, Size x,String string) {
		setColor(newColor);
		setPrice(newPrice);
		setCondition(newCondition);
	}
	/**
	 * Getter for the color of the clothing
	 * @return The color in string form 
	 */
	public String getColor() {
		return Color;
	}
	/**
	 * Setter method to set the color of the apparel
	 * @param newColor Will return the color of the clothing
	 */
	public void setColor(String newColor) {
		this.Color = newColor;
	}
	/**
	 * Getter method to get the price of the clothing
	 * @return Will return in double, the price
	 */
	public double getPrice() {
		return Price;
	}
	/**
	 * Setter method to set the price of the item 
	 * @param newPrice Will take in a double to set the price
	 */
	public void setPrice(double newPrice) {
		this.Price = newPrice;
	}
	/**
	 * Method to get the condition of the item 
	 * @return Condition
	 */
	public Project1.Apparel.Condition getCondition() {
		return Condition;
	}
	/**
	 * Setter method to set the condition of the item
	 * @param newCondition Take in the condition of the item
	 */
	public void setCondition(Condition newCondition) {
		this.Condition = newCondition;
	}
	/**
	 * This will be used for the condions of the items
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
		/**
		 * Tostring method to return the condion of the item 
		 */
		public String toString() { return mCond; }
	}
	
}
