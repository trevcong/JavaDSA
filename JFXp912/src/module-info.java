module JFXp912 {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens wardrobe to javafx.graphics, javafx.fxml;
}
