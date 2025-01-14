package Project1;
/**
 * Driver for the project will give preset objects to the parent class and will be displayed to the user in the console
 * There are 5 objects, 2 shirts and 3 pants that will display. 
 * @author Trevor Conger
 *
 */
public class WardrobeDriver {

	public static void main(String [] args) {
		Apparel firstItem;
		Apparel secondItem;
		Apparel thirdItem;
		Apparel fourthItem;
		Apparel fifthItem;
		Apparel sixthItem;
		firstItem = new Shirt("Red", 12.99, Apparel.Condition.GOOD, Shirt.Size.L, "I'm with the band" );
		secondItem = new Shirt("White", 9.99, Apparel.Condition.POOR, Shirt.Size.M, "");
		thirdItem = new Pants("Blue", 29.99, Apparel.Condition.NEW, 30, 32);
		fourthItem = new Pants("Black", 25.94, Apparel.Condition.TRASHED, 44, 35);
		fifthItem = new Pants("Khaki", 42.99, Apparel.Condition.GOOD, 40, 38);
		sixthItem = new Pants("Khaki", 23.55, Apparel.Condition.TRASHED, 34, 53);
		System.out.println(firstItem);
		System.out.println();
		System.out.println(secondItem);
		System.out.println();
		System.out.println(thirdItem);
		System.out.println();
		System.out.println(fourthItem);
		System.out.println();
		System.out.println(fifthItem);
		System.out.println();
		System.out.println(sixthItem);
	}
}
