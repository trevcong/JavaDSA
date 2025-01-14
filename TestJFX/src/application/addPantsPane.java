package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class 
addPantsPane
extends addApparelPane implements EventHandler<ActionEvent>
{
	/**
	 * Attribute for the TextField, will be for the waist size as an int
	 */
    private TextField waistTF;
    /**
     * Attribute for the TextField, will be for the inseam size as an int
     */
    private TextField inseamTF;
    /**
     * Attribute for the button to add the pants to a Wardrobe object
     */
    private Button addPantsB;
    /**
     * Attribute for the Wardrobe to send and save information 
     */
    private Wardrobe wdrb;    
    /**
     * Method addPantsPane , to add the pants to the pane to show the user that they have added a pants object to the screen
     * @param w
     */
    public addPantsPane(Wardrobe w){
    	super();
    	this.wdrb = w;
    	waistTF = new TextField();
    	waistTF.setPrefColumnCount(2);
    	inseamTF = new TextField();
    	inseamTF.setPrefColumnCount(2);
    	
    	addPantsB = new Button("Add Pants");
    	addPantsB.setOnAction(this);
    	
    	// put these items into a pane
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Waist Size (inches): "));
		temp.getChildren().add(waistTF);
		temp.getChildren().add(new Label("Inseam Size (inches): "));
		temp.getChildren().add(inseamTF);
    	// now add the pane into the superclass
		getChildren().add(temp);
		getChildren().add(addPantsB);
		
    }
    	
	/**
	 * clear -
	 *  clear out text fields - though maybe it would be better
	 *  to leave some values in place for easier entry of the next item.
	 */
	@Override
	protected void clear(){
		super.clear();
		waistTF.setText("");
		inseamTF.setText("");
	}
    /**
     * Handle method to wait for the Button to be pressed to then add all information to the screen, if anything is wrong there will be an Alert shown
     */
    @Override
    public void handle(ActionEvent e) {
    	if (e.getSource() == addPantsB) {
    		try {
    			Pants a = new Pants(
    					colorTF.getText(),
    					Double.parseDouble(priceTF.getText()),
    					conditionCB.getValue(),
    					Integer.parseInt(waistTF.getText()),
    					Integer.parseInt(inseamTF.getText())
    					);
    			wdrb.addApparel(a);
    			clear();
			}catch(NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Not a number");
				alert.setContentText("An expected number was: " + ex.getMessage());
				alert.showAndWait();
			}catch(IllegalArgumentException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Illegal Value");
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}
    	}
    }
}