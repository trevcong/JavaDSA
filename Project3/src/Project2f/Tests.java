package Project2f;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Trevor Conger
 * Project 3 Junit tests
 *
 */
class Tests {
  /**#1 Test valid constructor call for pants.
   * 
   */
	@Test
	public void testPantsCorrect() {
		Pants pants1 = new Pants("Red", 35.99, Apparel.Condition.NEW, 30, 32);
		assertEquals("Red", pants1.getColor());
		assertEquals(35.99, pants1.getPrice());
		assertEquals(Apparel.Condition.NEW, pants1.getCondition());
		assertEquals(30, pants1.getWaist());
		assertEquals(32, pants1.getInseam());
	}
	
	/**#2 Test pants constructor calls with illegal values
	 * 
	 */
	@Test
	public void testPants() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("", 34.99, Apparel.Condition.NEW, 30, 32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants(null, 34.99, Apparel.Condition.NEW, 30, 32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("Red", -34.99, Apparel.Condition.NEW, 30, 32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("Red", 34.99, null, 30, 32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("Red", 34.99, Apparel.Condition.NEW, -30, 32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("Red", 34.99, Apparel.Condition.NEW, 0, 32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("Red", 34.99, Apparel.Condition.NEW, 32, -32);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Pants("Red", 34.99, Apparel.Condition.NEW, 30, 0);
		});
	}
	/** #3 A valid constructor call for Shirt
	 * 
	 */
	@Test
	public void testShirt() {
		Shirt shirt1 = new Shirt("Red", 35.99, Apparel.Condition.NEW, Shirt.Size.XL, "");
		assertEquals("Red", shirt1.getColor());
		assertEquals(35.99, shirt1.getPrice());
		assertEquals(Apparel.Condition.NEW, shirt1.getCondition());
		assertEquals(Shirt.Size.XL, shirt1.getSize());
		assertEquals("", shirt1.getShirtText());
	}
	
	/** #4 Attempted shirt constructor calls with illegal values
	 * 
	 */
	@Test
	public void testShirtIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Shirt("", 35.99, Apparel.Condition.NEW, Shirt.Size.XL, "");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Shirt(null, 35.99, Apparel.Condition.NEW, Shirt.Size.XL, "");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Shirt("Red", -35.99, Apparel.Condition.NEW, Shirt.Size.XL, "");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Shirt("Red", 35.99, null, Shirt.Size.XL, "");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Shirt("Red", 35.99, Apparel.Condition.NEW, null, "");
		});
	}
	
	
	/** #5 Valid setter calls for Pants
	 * 
	 */
	@Test
	public void testSetPants() {
		Pants pants2 = new Pants("Red", 34.99, Apparel.Condition.NEW, 30, 32);
		pants2.setColor("Blue");
		pants2.setPrice(23.99);
		pants2.setCondition(Apparel.Condition.GOOD);
		pants2.setWaist(32);
		pants2.setInseam(30);
		assertEquals(30, pants2.getInseam());
		assertEquals(32, pants2.getWaist());
		assertEquals(Apparel.Condition.GOOD, pants2.getCondition());
		assertEquals(23.99, pants2.getPrice());
		assertEquals("Blue", pants2.getColor());
	}
	/** #6 Attempted pants setter calls with illegal values, W/ a check to make sure
	 * values have not been altered in a bad way
	 * 
	 */
	@Test
	public void testPantsSeters() {
		Pants pants3 = new Pants("Red", 34.99, Apparel.Condition.NEW, 30, 32);
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setColor("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setColor(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setPrice(-30);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setCondition(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setWaist(-30);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setWaist(0);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pants3.setInseam(-23);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 pants3.setInseam(0);
		});
		assertEquals("Red", pants3.getColor());
		assertEquals(34.99, pants3.getPrice());
		assertEquals(Apparel.Condition.NEW, pants3.getCondition());
		assertEquals(30, pants3.getWaist());
		assertEquals(32, pants3.getInseam());
	}
	
	/** Test 7
	 *  Check setter calls for Shirt
	 */
	@Test
	public void testSetShirt() {
		Shirt shirt2 = new Shirt("Red", 35.99, Apparel.Condition.NEW, Shirt.Size.XL, "");
		shirt2.setColor("Blue");
		shirt2.setPrice(23.99);
		shirt2.setCondition(Apparel.Condition.GOOD);
		shirt2.setShirtText("Hello");
		assertEquals("Hello", shirt2.getShirtText());
		assertEquals(Apparel.Condition.GOOD, shirt2.getCondition());
		assertEquals(23.99, shirt2.getPrice());
		assertEquals("Blue", shirt2.getColor());
	}
	
	/** 8
	 *  Attempted shirt setter calls with illegal values
	 */
	@Test
	public void testShirtSeters() {
		Shirt shirt3 = new Shirt("Red", 35.99, Apparel.Condition.NEW, Shirt.Size.XL, "");
		assertThrows(IllegalArgumentException.class, () -> {
			 shirt3.setColor("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 shirt3.setColor(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 shirt3.setPrice(-30);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 shirt3.setCondition(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			 shirt3.setSize(null);
		});
		assertEquals("Red", shirt3.getColor());
		assertEquals(35.99, shirt3.getPrice());
		assertEquals(Apparel.Condition.NEW, shirt3.getCondition());
		assertEquals(Shirt.Size.XL, shirt3.getSize());
	}
}
