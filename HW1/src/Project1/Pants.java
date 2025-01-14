package Project1;
/**
 * Pants child class that will take in information from the parent class and the driver
 * will return a toString with information if needed
 *
 */
public class Pants extends Apparel{
/**
 * Attribute for the waist size in int form
 */
	private int Waist;
	/**
	 * Attribute for the inseam size in int form
	 */
	private int Inseam;
	/**
	 * Constructor for the pants objects
	 * @param newColor Color of the item
	 * @param newPrice Price of the item
	 * @param newCondition Condition of the item
	 * @param Waist size in int
	 * @param Inseam size in int
	 */
	public Pants(String newColor, double newPrice, Project1.Apparel.Condition newCondition, int Waist, int Inseam) {
		super(newColor, newPrice, newCondition, null, newColor);
		this.Waist = Waist;
		this.Inseam = Inseam;
	}
	/**
	 * Getter method to get the waist size
	 * @return waist size in int
	 */
	public int getWaist() {
		return Waist;
	}
	/**
	 * Setter method to set the waist size 
	 * @param newWaist int of waist
	 */
	public void setWaist(int newWaist) {
		this.Waist = newWaist;
	}
	/**
	 * Getter method to get the inseam size
	 * @return the inseam size in int
	 */ 
	public int getInseam() {
		return Inseam;
	}
	/**
	 * Setter method to set the inseam size
	 * @param newInseam inseam in int
	 */
	public void setInseam(int newInseam) {
		this.Inseam = newInseam;
	}
	/**
	 * ToString to set the text for the pants object
	 */
	public String toString() {
		return "This " + (super.getColor()) + " pair of pants has a " + (getWaist()) + " inch waist and a " + (getInseam()) + " inch inseam. It cost $" + (super.getPrice()) + " and is in " + (super.getCondition()) + " condition.";
	}
}
