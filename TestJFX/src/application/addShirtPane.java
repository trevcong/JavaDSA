package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import application.Shirt.Size;

public class addShirtPane extends addApparelPane implements EventHandler<ActionEvent> {
	/**
	 * Attribute for the text field for the shirt text
	 */
	private TextField text;
	/**
	 * Attribute for the ComboBox for shirt Size 
	 */
	protected ComboBox<Shirt.Size> size;
	/**
	 * Button to be pressed when the user is done entering the information they have created
	 */
	private Button addShirtB;
	/**
	 * Wardrobe object to store the information to be sent to the Apparel class
	 */
	private Wardrobe wrdb;
	/**
	 * addShirtPane method to show the user in GUI form what to enter in the screen and will be used to add information to the textfield
	 * @param Shirt
	 */
	public addShirtPane(Wardrobe Shirt) {
		super();
		this.wrdb = Shirt;
		text = new TextField();
		text.setPrefColumnCount(2);
		size = new ComboBox<Shirt.Size>();
		size.getItems().addAll(Size.values());
		
		addShirtB = new Button("Add shirt");
		addShirtB.setOnAction(this);
		
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Shirt text: "));
		temp.getChildren().add(text);
		temp.getChildren().add(new Label("Size of shirt: "));
		temp.getChildren().add(size);
		
		getChildren().add(temp);
		getChildren().add(addShirtB);
	}
	/**
	 * Method to clear the screen of any selected information or text once they have submitted correct information 
	 */
	@Override
	protected void clear() {
		super.clear();
		text.setText("");
		size.getSelectionModel().select(0);
	}
	/**
	 * Method to handle once the user has pressed the button "add shirt" will then create a Wardrobe object to be added to the textfield
	 */
	public void handle(ActionEvent e) {
    	if (e.getSource() == addShirtB) {
    		try {
    			String str = "";
    			Shirt a = new Shirt(
    					colorTF.getText(),
    					Double.parseDouble(priceTF.getText()),
    					conditionCB.getValue(),
    					size.getValue(),
    				str +=	text.getText()
    					);
    			wrdb.addApparel(a);
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