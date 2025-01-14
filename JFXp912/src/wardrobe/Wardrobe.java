package wardrobe;



import java.util.ArrayList;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

 * COS212 Project 9 Template
 * 
 * Some elements are already written for you.
 * 
 * Some elements we will write together, including AddApparelPanel and AddPantsPanel classes 
 * (see code-along videos)
 * 
 * You will need to write the AddShirtPanel class as homework.
 * 
 * @author Nathan Gossett
 * @version Spring 2021
 *
 */

public class Wardrobe extends Application{
	/** Store the list of clothes in the wardrobe */
	private ArrayList<Apparel> myClothes;
	
	/** A place to print the list of games */
	private TextArea apparelList;

	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 625, 500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("My wardrobe gui");
			
			apparelList = new TextArea();
			apparelList.setPrefSize(625,325);
			apparelList.setWrapText(true);
			apparelList.setEditable(false);
			
			ScrollPane listP = new ScrollPane(apparelList);
			root.setTop(listP);
			
			//my clothes closet -- for holding clothes
			//myClothes = new ArrayList<Apparel>();
		    //populate();
			
			TabPane tab = new TabPane();
			Tab ShirtPane = new Tab();
			ShirtPane.setText("Shirt");
			ShirtPane.setContent(new addShirtPane(this));
			tab.getTabs().add(ShirtPane);
			
			Tab PantsPane = new Tab();
			PantsPane.setText("Pants");
			PantsPane.setContent(new addPantsPane(this));
			tab.getTabs().add(PantsPane);
			
			root.setCenter(tab);
			
			
			
			
			
			
			//addApparelPane addApparel = new addApparelPane();
			//root.setBottom(addApparel);
			

		
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * A method to hard-code some example clothes
	 */
	private void populate(){
		//TODO once we write the addApparel() method, uncomment these
//		addApparel(new Shirt("red", 12.99, Apparel.Condition.GOOD, Shirt.Size.L, "I\'m with the band"));
//		addApparel(new Shirt("white", 9.99, Apparel.Condition.POOR, Shirt.Size.M, null));
//		addApparel(new Pants("blue", 29.99, Apparel.Condition.NEW, 30, 32));
	}
	
	/**
	 * Override the default toString to print a list of the clothes
	 * in the wardrobe
	 */
	public String toString(){
		String myString = "";
		for(Apparel a : myClothes){
			myString += a + "\n\n";
		}
		return myString;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}

/**

			Tab BoardGameTab = new Tab();
			BoardGamePane bg = new BoardGamePane(this);
			BoardGameTab.setText("Board Game");
			tabpanes.getTabs().addAll(BoardGameTab);
			BoardGameTab.setContent(bg);
			**/
