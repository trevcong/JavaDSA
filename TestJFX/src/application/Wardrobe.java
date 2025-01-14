package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import application.Apparel;
import application.addPantsPane;
// added:
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * COS212 Project 9 Template
 * 
 * Some elements are already written for you.
 * 
 * Some elements we will write together, 
 * including AddApparel_Panel and AddPants_Panel classes 
 * (see code-along videos)
 * 
 * You will need to write the AddShirt_Panel class as homework.
 * 
 * @author Gossett, revised
 * @version 21.4.cxxxsxss   
 *
 */

public class Wardrobe extends Application {

	/** Store the list of clothes in the wardrobe */
	private ArrayList<Apparel> myClothes;
	
	/** A place to print the list of apparel */
	private TextArea apparelList;

	/**
	 * Method to start the GUI where I will show the things needed to make a Shirt or a Pants variable
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 625, 500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("My Wardrobe GUI");

			// create GUI elements and place on screen
			apparelList = new TextArea();
			apparelList.setPrefSize(625,325);
			apparelList.setWrapText(true);
			apparelList.setEditable(false);
			
			ScrollPane listP = new ScrollPane(apparelList);
			root.setTop(listP);
			
			// my clothes closet -- for holding the clothing
			myClothes = new ArrayList<Apparel>();
			populate();		// put some clothes in the closet
		
	        TabPane addPane = new TabPane();
	        root.setBottom(addPane);	// add it to the BorderPane

	        addPantsPane aPantsPanel = new addPantsPane(this);
	        aPantsPanel.setPrefSize(625, 175);
	        addPane.getTabs().add(new Tab("Add Pants", aPantsPanel));
	        
	        addShirtPane aShirtPanel = new addShirtPane(this);
	        aShirtPanel.setPrefSize(625, 175);
	        addPane.getTabs().add(new Tab("Add Shirt", aShirtPanel));
	        // TODO: add a tab for a ShirtPanel
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	} // start
    
    /**
     * Update the text area with the current apparel
     */
    private void redoList(){
        apparelList.setText(this.toString());
    }

    /** 
     * Add the provided piece of clothing to the list
     * @param item This will add an item to the ArrayList
     */
    protected void addApparel(Apparel item){
        myClothes.add(item);
        Collections.sort(myClothes);
        redoList();
    }

	/**
	 * A method to hard-code some example clothes
	 */
	private void populate(){
		//addApparel(new Shirt("red", 12.99, Apparel.Condition.GOOD, Shirt.Size.L, "I\'m with the band"));
		//addApparel(new Shirt("white", 9.99, Apparel.Condition.POOR, Shirt.Size.M, null));
		//addApparel(new Pants("blue", 29.99, Apparel.Condition.NEW, 30, 32));
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
	 * Main launch method
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
} 