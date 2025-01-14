package dsgeneric;

public class Driver {

	public static void main(String[] args) {
		BigData <String> stringBag = new BigData<String>();
		
		BigData <Integer> numberBag = new BigData<Integer>();
		
		BigData <String> diamond = new BigData<String>();
		
		stringBag.setData("Hello");
		//stringBag.setData(4);
		
		numberBag.setData(4);
		//numberBag.setData("Hello");
		
		String word = (String) stringBag.getData();
		
		BigData raw = new BigData();
		raw.setData("Hello");
		raw.setData(4);
		
		String output = (String) raw.getData();
		
		 
		
		
	}
	
}
