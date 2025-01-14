package file;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("poem.txt");
			writer.write("Roses are red \n Violets are blue \n booty");
			writer.append("\n a powem");
			writer.close(); // be sure to close the writer when you are done
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
}
