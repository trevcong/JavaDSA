
	package wordstat;

	import org.junit.jupiter.api.Test;

	/**
	 * A class with intentional error(s) to demonstrate method tests
	 * and debugging
	 * @author Dr. Albing, based on N. Gossett
	 * @version Fall 2021
	 *
	 */
	public class WordStat 
	{
		
		/**
		 * Check whether a String starts with a Vowel
		 * @param s the String to test
		 * @return true if the first character is a vowel, false otherwise
		 */
		public static boolean 
		startsWithVowel(String s)
		{
			char c = s.toLowerCase().charAt(1); //intentional error for us to find
			return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
		}
		
		/**
		 * The method to debug
		 * Counts which letter is the most common in a string (case insensitive)
		 * @param someStr The string to test
		 * @return The letter that shows up the most times, in event of a tie,
		 * first alphabetically
		 */
		public static char 
		mostCommonLetter(String someStr)
		{
			char mostCommon = '*';//need some dummy value to start
			int mostCommonCount = 0;//anyone can beat the dummy value
			char current = 'a';
			String s = someStr.toLowerCase(); // once, for easy comparisons
			
			while(current <= 'z'){//loop through all 26 letters
				int count = 0;
				for(int i = 0; i < s.length(); i++){
					if(s.charAt(i) == current){
						count++;//found another one
					}
				}
				if(count > mostCommonCount){
					mostCommon = current;//new winner
					// intentional error for us to find
				}
				//Since char data is actually the same as a byte 
				//underneath, we can do arithmetic with the char value
				//'a' + 1 is 'b', 'b' + 1 is 'c', etc
				current++;//move to the next letter
			}
			return mostCommon;//whatever letter ended up winning overall
			
		} // mostCommonLetter
		
		
		void test() {
			assert true;
		}
		  
		//Using a tool like JUnit to test your code is better than this, but we technically won't
		//talk about JUnit until next week, so here's a quick and dirty unit test:
		public static void 
		main(String[] args) {
			char commonLetter;
			
			if(!startsWithVowel("Aardvark"))
				System.out.println("Aardvark is a problem");
			if(!startsWithVowel("aardvark"))
				System.out.println("aardvark is a problem");
			if(!startsWithVowel("Einstein"))
				System.out.println("Einstein is a problem");
			if(!startsWithVowel("outdoors"))
				System.out.println("outdoors is a problem");
			if(startsWithVowel("structured"))
				System.out.println("structured is a problem");
			if(startsWithVowel("programming"))
				System.out.println("programming is a problem");
			if(startsWithVowel("computer"))
				System.out.println("computer is a problem");
			if(startsWithVowel("Science"))
				System.out.println("Science is a problem");
			
			commonLetter = WordStat.mostCommonLetter("Ubuntu");
			if(commonLetter != 'u') {
				System.out.print("Ubuntu is a problem; instead of 'u', we got: ");
			    System.out.println(commonLetter);
			}

			commonLetter = WordStat.mostCommonLetter("bookkeeper");
			if(commonLetter != 'e') {
				System.out.print("bookkeeper is a problem; instead of 'e', we got: ");
			    System.out.println(commonLetter);
			}
			
		} // main

	} // class WordStats
