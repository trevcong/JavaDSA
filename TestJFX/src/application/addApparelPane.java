package application;


import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class addApparelPane extends VBox{
	/**
	 * Attribute for the color of the Apparel in textfield form
	 */
protected TextField colorTF;
/**
 * Attribute for the ComboBox that will be for the condition of the apparel 
 */
protected ComboBox<Apparel.Condition> conditionCB;
/**
 * Attribute for the TextField for the price of the apparel
 */
protected TextField priceTF;
	/**
	 * Method to add the GUi to the screen to show the user where to enter information
	 */
	public addApparelPane() {
		super();
		colorTF = new TextField();
		priceTF = new TextField();
		conditionCB = new ComboBox<Apparel.Condition>();
		conditionCB.getItems().addAll(Apparel.Condition.values());
		
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Apparel color: "));
		temp.getChildren().add(colorTF);
		getChildren().add(temp);
		
		temp = new FlowPane();
		temp.getChildren().add(new Label("Apparel condition: "));
		temp.getChildren().add(conditionCB);
		getChildren().add(temp);
		
		temp = new FlowPane();
		temp.getChildren().add(new Label("Price: $"));
		temp.getChildren().add(priceTF);
		getChildren().add(temp);
		
	}
	/**
	 * Method to clear the screen of selected or text left on screen
	 */
	protected void clear() {
		colorTF.setText("");
		priceTF.setText("");
		conditionCB.getSelectionModel().select(0);
	}
}
