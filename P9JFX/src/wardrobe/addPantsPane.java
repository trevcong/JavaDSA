package wardrobe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addPantsPane extends addApparelPane implements EventHandler<ActionEvent> {

	private TextField waistTF;
	private TextField inseamTF;
	private Wardrobe wdrb;
	private Button submit; 
	
	public addPantsPane(Wardrobe w) {
		super();
		this.wdrb = w;
		waistTF = new TextField();
		waistTF.setPrefColumnCount(2);
		inseamTF = new TextField();
		inseamTF.setPrefColumnCount(2);
		
		
		
		this.getChildren().add(new Label("Waist size "));
		waistTF = new TextField();
		//add(waistTF, 1, 0);
		
		

		submit = new Button("Submit pants");
		submit.setOnAction(this);
		this.getChildren().add(submit);
		
		
		
		
		
		//add positions
		
		
		
		
		
		
		
		
	}
	
	//clear function here
	//Will set the button to not pressed, and cleared the textfields
	
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource() == submit) {
			try {
				Pants a = new Pants(
						colorTF.getText(), 
						Double.parseDouble(priceTF.getText()),
						conditionCB.getValue(),
						Integer.parseInt(waistTF.getText()),
						Integer.parseInt(inseamTF.getText())
						);
				
				wdrb.addArray(a);
				wdrb.displayArray();
				
				clear();
			}catch(Exception a) {
				
			}
		}
	}
	
}
