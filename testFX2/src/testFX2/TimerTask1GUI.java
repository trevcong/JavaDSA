package testFX2;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class TimerTask1GUI extends VBox implements EventHandler<ActionEvent>{
/**
 * Attribute for the button to add to the header
 */
	private Button add;
/**
 * Attribute to remove from the header	
 */
	private Button remove;
/**
 * Attribute for the textfield that the user will add the header text to 	
 */
	private TextField header;
/**
 * textarea that the user will be displaying the message to	
 */
	protected TextArea output;
/**
 * ArrayList that the user will be adding their headers to	
 */
	public static ArrayList<String> llist = new ArrayList<String>();
/**
 * Constructor for the GUI	
 */
	public TimerTask1GUI(){
		
		header = new TextField();
		header.setPrefColumnCount(2);
		header.setPrefSize(170, 30);
		
		add = new Button("Add");
		add.setOnAction(this);
		
		remove = new Button("Remove");
		remove.setOnAction(this);
		
		FlowPane timer = new FlowPane();
		timer.getChildren().add(new Label("Header message:"));
		timer.getChildren().add(header);
		timer.getChildren().add(add);
		timer.getChildren().add(remove);
		
		this.getChildren().add(timer);
		
		output = new TextArea();
		
	}
/**
 * Method to clear the screen	
 */
	protected void clear() {
		header.setText("");
	}
/**
 * Handle method to handle what the user is giving to the user	
 */
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource() == add) {
			try {
			
				llist.add(header.getText());
				
				Timer timer = new Timer();
				if(!llist.isEmpty()) {
					for(int i = 0; i < llist.size(); i++) {
						int index = i;
						timer.schedule(new TimerTask() {
				            @Override
				             public void run() {
				            	 output.setText(llist.get(index));
				             }
				         }, (3000));
					}
				}
				
			}catch(IllegalArgumentException ex)  {
				
			}
		}else if(e.getSource() == remove) {
			try {
				//TODO: FIX THIS
			llist.remove(0);
			}catch(IllegalStateException ex) {
				
			}
		}
	}

}
