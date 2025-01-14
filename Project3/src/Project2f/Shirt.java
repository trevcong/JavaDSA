package Project2f;

/**
 * 
 * @author Trevor Conger
 * This is the shirt class, to gather information and present to user if shirt is selected.
 *
 */
public class Shirt extends Apparel{
	/**
	 * A size object of type Project2f.Shirt.Size of size
	 */
	private Project2f.Shirt.Size Size;
	/**
	 * A variable to store the shirttext that the user supplys
	 */
	private String ShirtText;
	/**
	 * constructor for the Shirt class
	 * @param newColor Color of the Shirt
	 * @param newPrice Price of the shirt
	 * @param newCondition Condition of the shirt
	 * @param Size Size of the shirt
	 * @param ShirtText Shirt text if any provided by the user
	 */
	public Shirt(String newColor, double newPrice, Project2f.Apparel.Condition newCondition, Project2f.Shirt.Size Size, String ShirtText) {
		super(newColor, newPrice, newCondition, null, ShirtText) ;
		setShirtText(ShirtText);
		setSize(Size);
	}
	/**
	 * Enum method to make sure the user supplys a correct size
	 *
	 */
	public enum Size{
		S("s"),
		M("m"),
		L("l"),
		XL("xl");
		private final String mCond;
		Size(String cond){
			mCond = cond;
		}
		public String toString() { return mCond; }
	}
	/**
	 * getter method to return the size of the shirt to the user
	 * @return Size of type Project2f.Shirt.Size
	 */
	public Project2f.Shirt.Size getSize() {
		return Size;
	}
	/**
	 * Setter method to set the size of the shirt
	 * @param newSize Shirt size  given by the user
	 */
	public void setSize(Size newSize){
		if(newSize == null) {
			throw new IllegalArgumentException("Condition cant be null");
		}
		this.Size = newSize;
	}
	/**
	 * Getter method to get the text on the shirt if there is any text to be given
	 * @return Will return the shirtText 
	 */
	public String getShirtText() {
		return ShirtText;
	}
	/**
	 * Setter method to set the shirt text from a user input
	 * @param newShirtText A string for the shirtText
	 */
	public void setShirtText(String newShirtText) {
		this.ShirtText = newShirtText;
	}
	/**
	 * toString method to return a string of the right paramiters if the user has a shirt that needs text on it
	 */
	public String toString() {
		if(getShirtText().equals("")) {
			return "This size " + Size + " " + (super.getColor()) + " Shirt cost $" + (super.getPrice()) + " and is in " + (super.getCondition()) + " condition.";
		}else{
			return "This size " + Size + " " + (super.getColor()) + " Shirt cost $" + (super.getPrice()) + " and is in " + (super.getCondition()) + " condition. It contains the text " + ShirtText;		  
		}
	}
}
