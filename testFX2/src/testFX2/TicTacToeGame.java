package testFX2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class TicTacToeGame extends Application {
  // Indicate which player has a turn, initially it is the X player
  private char playerTurn = 'X';

  // Create and initialize the game board
  private Board[][] gameBoard =  new Board[3][3];

  // Create and initialize a status label
  private Label lStatus = new Label("Player X's turn");
 // gridpane for the playing board
  private GridPane pane = new GridPane();
  
  @Override 
  public void start(Stage primaryStage) {
	  //code to display the game board
	    for (int row = 0; row < 3; row++) {
	      for (int col = 0; col < 3; col++) {
	        pane.add(gameBoard[row][col] = new Board(), row, col);
	      }
	    }
	    
//setting game board and text for the players on the top left
    BorderPane bp = new BorderPane();
    bp.setCenter(pane);
    bp.setTop(lStatus);
    
    
   
   	
   	
      
       
    // Create a scene and place it in the stage
    Scene scene = new Scene(bp, 700, 700);
    primaryStage.setTitle("TicTacToe"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
    
    
    
    
    

    
   
    
  }

  /** Determine if the cell are all occupied */
  public boolean isDraw() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (gameBoard[i][j].getPlayer() == ' ')
          return false;

    return true;
  }

  /** Determine if one of the players win */
  public boolean playerWon(char player) {
    for (int i = 0; i < 3; i++)
      if (gameBoard[i][0].getPlayer() == player
          && gameBoard[i][1].getPlayer() == player
          && gameBoard[i][2].getPlayer() == player) {
        return true;
      }

    for (int j = 0; j < 3; j++)
      if (gameBoard[0][j].getPlayer() ==  player
          && gameBoard[1][j].getPlayer() == player
          && gameBoard[2][j].getPlayer() == player) {
        return true;
      }

    if (gameBoard[0][0].getPlayer() == player 
        && gameBoard[1][1].getPlayer() == player        
        && gameBoard[2][2].getPlayer() == player) {
      return true;
    }

    if (gameBoard[0][2].getPlayer() == player
        && gameBoard[1][1].getPlayer() == player
        && gameBoard[2][0].getPlayer() == player) {
      return true;
    }

    return false;
  }

  
  public class Board extends Pane {
   
    private char player = ' ';
/**
 * handling adding the markers when a player clicks one of the spaces
 */
    public Board() {
      setStyle("-fx-border-color: black"); 
      this.setPrefSize(400,400);
      this.setOnMouseClicked(e -> handleMouseClick());
    }

    /** Return player */
    public char getPlayer() {
      return player;
    }

    /** Set a new player  */
    public void setPlayer(char c) {
    	player = c;
      
      if (player == 'X') {
        Line line1 = new Line(10, 10, 
          this.getWidth() - 15, this.getHeight() - 15);
        line1.endXProperty().bind(this.widthProperty().subtract(15));
        line1.endYProperty().bind(this.heightProperty().subtract(15));
        Line line2 = new Line(15, this.getHeight() - 15, 
          this.getWidth() - 15, 15);
        line2.startYProperty().bind(
          this.heightProperty().subtract(15));
        line2.endXProperty().bind(this.widthProperty().subtract(15));
        
        // Add the lines to the pane
        this.getChildren().addAll(line1, line2); 
      }
      else if (player == 'O') {
        Ellipse O = new Ellipse(this.getWidth() / 2, 
          this.getHeight() / 2, this.getWidth() / 2 - 10, 
          this.getHeight() / 2 - 10);
        O.centerXProperty().bind(
          this.widthProperty().divide(2));
       O.centerYProperty().bind(
            this.heightProperty().divide(2));
       O.radiusXProperty().bind(
            this.widthProperty().divide(2).subtract(15));        
        O.radiusYProperty().bind(
            this.heightProperty().divide(2).subtract(15));   
        O.setStroke(Color.BLACK);
        O.setFill(Color.WHITE);
        
        getChildren().add(O); 
      }
    }

    /* Handle a mouse click event */
    private void handleMouseClick() {
      if (player == ' ' && playerTurn != ' ') {
        setPlayer(playerTurn); 

        // Check game status
        if (playerWon(playerTurn)) {
          lStatus.setText(playerTurn + " won!");
          playerTurn = ' ';
          
          
        }
        //checking for a tie
        else if (isDraw()) {
          lStatus.setText("It's a draw");
          playerTurn = ' '; 
        }
        else {
          
          playerTurn = (playerTurn == 'X') ? 'O' : 'X';
         
          lStatus.setText(playerTurn + "'s turn");
        }
      }
    }
  }
  
  
  
  public static void main(String[] args) {
    launch(args);
  }
}