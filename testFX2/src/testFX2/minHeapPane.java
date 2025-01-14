package testFX2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;



public class minHeapPane extends VBox implements EventHandler<ActionEvent> {
/**
 * Attribute for the textfield for the priority of the task
 */
	private TextField priority;
/**
 * Attribute for the textfield for the task 	
 */
	private TextField task;
/**
 * Attribute for the button to add to the minheap	
 */
	private Button add;
/**
 * Attribute for the button to remove from the minheap	
 */
	private Button remove;
/**
 * Attribute to add to the textarea on the screen
 */
	protected TextArea output;
/**
 * Communication to minheap class to sort the heap	
 */
	MinHeap<PrioTask> mh;
	
/**
 * Main constructor for the class
 */
	public minHeapPane() {
		
		mh = new MinHeap<PrioTask>(100);
		
		priority = new TextField();
		task = new TextField();
		priority.setPrefColumnCount(2);
		task.setPrefColumnCount(2);
		task.setPrefSize(170, 30);
		
		add = new Button("Add");
		add.setOnAction(this);
		
		remove = new Button("Remove");
		remove.setOnAction(this);
		
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Priority:"));
		temp.getChildren().add(priority);
		temp.getChildren().add(new Label("Task:"));
		temp.getChildren().add(task);
		temp.getChildren().add(add);
		temp.getChildren().add(remove);
		
		this.getChildren().add(temp);
		
		output = new TextArea();
		
		
	}
	
	/**
	 * method to clear the textfields on screen
	 */
	protected void clear() {
		priority.setText("");
		task.setText("");
	}
/**
 * 
 * Nested class to compare the priority of the classes this will help for the min heap 
 *
 */
	private class PrioTask implements Comparable<PrioTask>{
/**
 * Attribute for the task of type string
 */
		private String task;
/**
 * Attribute for the priority of the task		
 */
		private int prio;
/**
 * Constructor for the nested class	
 * @param x priority 
 * @param y the task at hand
 */
		public PrioTask(int x, String y) {
			prio = x;
			task = y;
		}
/**
 * compareTo method to compare what is going to be displayed from minheap		
 */
		@Override
		public int compareTo(PrioTask o) {
			if(o.prio > this.prio) return -1;
			else if(o.prio < this.prio) return 1;
			else return 0;
		}
/**
 * 	To string method to print out to the screen	
 */
		@Override
		public String toString() {
			return (prio + " " + task);
		}
	}
/**
 * Method to display to the user the minHeap first index
 */
	public void display() {
		output.setText(mh.findMax() + "");
	}
/**
 * 	Method to display to the user after something has been deleted 
 */
	public void displayDel() {
		output.setText(mh.deleteMax() + "");
	}
	//hash map
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource() == add) {
			try {
				
				PrioTask tests = new PrioTask(Integer.parseInt(priority.getText()), task.getText());
				System.out.println(tests);
				mh.insert(tests);
				clear();
				display();
			}
		catch(IllegalArgumentException ex ) {
			ex.getMessage();
			}
		}else if(e.getSource() == remove) {
			try {
			mh.deleteMax();
			displayDel();
			clear();
			}
		catch(IllegalStateException ex) {
			
			}
		}	
	}
}
