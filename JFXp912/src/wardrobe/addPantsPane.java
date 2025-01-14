package wardrobe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addPantsPane extends addApparelPane implements EventHandler<ActionEvent> {

	private TextField waistTF;
	private TextField inseamTF;
	private Button addPantsButton;
	private Wardrobe wdrb;
	
	public addPantsPane(Wardrobe w) {
		super();
		this.wdrb = w;
		waistTF = new TextField();
		waistTF.setPrefColumnCount(2);
		inseamTF = new TextField();
		inseamTF.setPrefColumnCount(2);
		
		addPantsButton = new Button("Add Pants");
		addPantsButton.setOnAction(this);
		
		
		
		
		
		
		
		//add positions
		
		
		
		
		
		
		
		
	}
	
	//clear function here
	//Will set the button to not pressed, and cleared the textfields
	
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource() == addPantsButton) {
			try {
				Pants a = new Pants(
						colorTF.getText(), 
						Double.parseDouble(priceTF.getText()),
						conditionCB.getValue(),
						Integer.parseInt(waistTF.getText()),
						Integer.parseInt(inseamTF.getText())
						);
			//	wdrb.addApparel(a);
				clear();
			}catch(Exception a) {
				
			}
		}
	}
	
}
