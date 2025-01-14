

package testFX2;

/**
 * Should spawn a blank window to verify that JavaFX is working
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javafx.stage.Stage;


public class JavaFXTest extends Application implements EventHandler<ActionEvent> {
	
	
	/*
	 * text area for the rotating linked list task
	 */
	private TextArea center;
	/**
	 * textarea for the stack task
	 */
	protected TextArea right;
	/**
	 * button to pop up tic tac toe game
	 */
	private Button tttB;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,root.computeAreaInScreen(),root.computeAreaInScreen());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Organize shopping and TIC-TAC-TOE");
			/**
			 * flowpane for the minheap task
			 */
			FlowPane fp= new FlowPane();
			FlowPane p= new FlowPane();
			FlowPane pg= new FlowPane();
			
			
			p.setPrefSize(200,200);
			fp.setPrefSize(200, 200);
			pg.setPrefSize(200, 200);
			
			root.setLeft(fp);
			root.setCenter(p);
			root.setRight(pg);
			
			/**
			 * setting up the tab pane on the bottom half of the gui
			 * tab1- tab for the minheap task
			 */
			TabPane tasktic = new TabPane();
			minHeapPane mhp = new minHeapPane();
			Tab tab1 = new Tab();
			tab1.setText("Priority");
			tab1.setClosable(false);
			tab1.setContent(mhp);
			tab1.setClosable(false);
			tasktic.getTabs().add(tab1);
			tasktic.setPrefSize(600, 200);
			root.setBottom(tasktic);
			fp.getChildren().add(mhp.output);
			
			/**
			 * timer task 
			 */
			TimerTask1GUI gi = new TimerTask1GUI();
			tasktic.getTabs().add(new Tab("Timer",gi));
			p.getChildren().add(gi.output);
			
			/**
			 * tab for the stack task
			 */
			Task3Tab t3t= new Task3Tab(this);
			Tab tab3 = new Tab();
			tab3.setText("Stack");
			pg.getChildren().add(t3t.output);
			tab3.setClosable(false);
			tab3.setContent(t3t);
			tasktic.getTabs().add(tab3);
			root.setBottom(tasktic);
			
			/**
			 * button for the tic tac toe game
			 */
	        tttB= new Button();
	        tttB.setText("Start Tic Tac Toe Game");
	        tttB.setOnAction(this);
	        Tab tab4 = new Tab();
	        tab4.setText("Tic Tac Toe");
	        tab4.setClosable(false);
	        tab4.setContent(tttB);
	        tasktic.getTabs().add(tab4);
	        root.setBottom(tasktic);
	        
	        
		
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * handle method to get the gui for the tic tac toe game 
	 * to display in a different window
	 */
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource() == tttB) {
			try {
				BorderPane secondaryLayout= new BorderPane();
		        Scene secScene = new Scene(secondaryLayout, 700, 700);
		        Stage stage= new Stage();
		        stage.setScene(secScene);
		        TicTacToeGame game = new TicTacToeGame();
		        game.start(stage);
		        stage.show();
		        
		    } catch(Exception ex) {
		        ex.printStackTrace();
		    }
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}