package testFX2;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class Task3Tab extends FlowPane implements EventHandler<ActionEvent> {
	private JavaFXTest myOwner;
	/**
	 * textfield to add to stack
	 */
	private TextField T3TF = new TextField();
/**
 * label for textfield
 */
	private Label T3L;
/**
 * button to add to stack
 */
	private Button T3Add = new Button("Add Task");
/**
 * button to delete from stack
 */
	private Button T3Delete = new Button("Delete Task");
	
	protected TextArea output;
/**
 * 
 * 
 * Array list for storing values
 */
	List<String> list = new ArrayList<>();

	public Task3Tab(JavaFXTest myOwner) {
		super();
		this.myOwner = myOwner;
		/**
		 * Label for the text field to add a task to the stack
		 */
		T3L = new Label("New Task:");
		HBox t3HB = new HBox();
		t3HB.getChildren().add(T3L);
		t3HB.getChildren().add(T3TF);

		/**
		 * Add button- acts like a push
		 */
		HBox T3AddHB = new HBox();
		T3AddHB.getChildren().add(T3Add);
		T3Add.setOnAction(this);

		/**
		 * Delete Button- acts like a pop
		 */
		HBox T3DelHB = new HBox();
		T3DelHB.getChildren().add(T3Delete);
		T3Delete.setOnAction(this);

		this.getChildren().add(t3HB);
		this.getChildren().add(T3AddHB);
		this.getChildren().add(T3DelHB);
		
		output = new TextArea();
	}

	public void display() {
		output.setText(list + "\n");
	}
	

	// *handle method for adding a task to the stack
	// T3Add will add new text to top like a push
	// T3Delete will delete the first item like a pop
	@Override
	public void handle(ActionEvent arg0) {
		if (arg0.getSource() == T3Add) {
			list.add(0, T3TF.getText());
			display();
		//	String listString = String.join("\n", list);
			//myOwner.right.setText(listString);// puts into task3 text area

			T3TF.clear();
		} else if (arg0.getSource() == T3Delete) {
			list.remove(0);
			String listString2 = String.join("\n", list);
			myOwner.right.setText(listString2);
		}

	}

}