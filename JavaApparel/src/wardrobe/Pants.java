package wardrobe;


/**
 * Pants child class that will take in information from the parent class and the driver
 * will return a toString with information if needed
 *
 */
public class Pants extends Apparel{
/**
 * Variable to store the Waist size
 */
	private int Waist;
/**
 * Variable to store the inseam size	
 */
	private int Inseam;
/**
 * Constructor for the pants class that will take in input provided by the user and will set items 	
 * @param newColor Color of the pants 
 * @param newPrice Price of the pants
 * @param newCondition Condition of the pants
 * @param Waist Waist size of the pants
 * @param Inseam Inseam size of the pants
 **/
	public Pants(String newColor, double newPrice, Condition newCondition, int Waist, int Inseam) {
		super(newColor, newPrice, newCondition);
			setWaist(Waist);
			setInseam(Inseam);
	}
	/**
	 * Getter method to get the waist size of the pants
	 * @return Will return the waist size 
	 */
	public int getWaist() {
		return Waist;
	}
	/**
	 * setter method to set the waist size
	 * @param newWaist Waist size the user gives
	 * @throws IllegalArgumentException Will throw an exception if the user gives a negative waist size
	 */
	public void setWaist(int newWaist) throws IllegalArgumentException{
		if(newWaist <= 0) {
			throw new IllegalArgumentException("Waist can't be negative");
		}
		this.Waist = newWaist;
	}
	/**
	 * Getter method to get the inseam size
	 * @return Will return the inseam size to the user
	 */
	public int getInseam() {
		return Inseam;
	}
	/**
	 * Setter method to set the inseam size
	 * @param newInseam Size the user gives of type int
	 * @throws IllegalArgumentException Will throw an exception if the user gives a negative number 
	 */
	public void setInseam(int newInseam) throws IllegalArgumentException{
		if(newInseam <= 0) {
			throw new IllegalArgumentException("Inseam can't be negative");
		}
		this.Inseam = newInseam;
	}
	/**
	 * To string method that will print out to the user the conditions they give
	 */
	public String toString() {
		return "This " + (super.getColor()) + " pair of pants has a " + (getWaist()) + " inch waist and a " + (getInseam()) + " inch inseam. It cost $" + (super.getPrice()) + " and is in " + (super.getCondition()) + " condition.";
	}
}
