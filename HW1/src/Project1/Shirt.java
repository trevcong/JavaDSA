package Project1;
/**
 * 
 * @author Trevor Conger
 * This is the shirt class, to gather information and present to user if shirt is selected.
 *
 */
public class Shirt extends Apparel{
	/**
	 * Attribute for the size of the item
	 */
	private Project1.Shirt.Size Size;
	/**
	 * Attribute for the shirt text in string form
	 */
	private String ShirtText;
	/**
	 * Constructor for the object of shirts
	 * @param newColor Color of the item
	 * @param newPrice Price of the item
	 * @param newCondition Condition of the item
	 * @param Size Size of the item
	 * @param ShirtText Shrit text
	 */
	public Shirt(String newColor, double newPrice, Project1.Apparel.Condition newCondition, Project1.Shirt.Size Size, String ShirtText) {
		super(newColor, newPrice, newCondition, null, ShirtText) ;
		this.ShirtText = ShirtText;
		this.Size = Size;
	}
	/**
	 * Method for the size of the shirts
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
	 * Method to get the size of the item
	 * @return Size
	 */
	public Project1.Shirt.Size getSize() {
		return Size;
	}
	/**
	 * Method to set the size of the item
	 * @param newSize Take in the size of Size
	 */
	public void setSize(Size newSize){
		this.Size = newSize;
	}
	/**
	 * Method to get the shirt text
	 * @return String shrittext
	 */
	public String getShirtText() {
		return ShirtText;
	}
	/**
	 * Method to set the shirt text
	 * @param newShirtText Take in String for the text of the shirt
	 */
	public void setShirtText(String newShirtText) {
		this.ShirtText = newShirtText;
	}
	/**
	 * TO string to make the shirt object, will appear with no shirt text if there is nothing
	 */
	public String toString() {
		if(getShirtText().equals("")) {
			return "This size " + Size + " " + (super.getColor()) + " Shirt cost $" + (super.getPrice()) + " and is in " + (super.getCondition()) + " condition.";
		}else{
			return "This size " + Size + " " + (super.getColor()) + " Shirt cost $" + (super.getPrice()) + " and is in " + (super.getCondition()) + " condition. It contains the text " + ShirtText;		  
		}
	}
	
}
