package wardrobe;


import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class addApparelPane extends VBox{
protected TextField colorTF;
protected ComboBox<Apparel.Condition> conditionCB;
protected TextField priceTF;

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
		
		
		
	}
	
	protected void clear() {
		colorTF.setText("");
		priceTF.setText("");
		conditionCB.getSelectionModel().select(0);
		
		
		
	}
	
}
