module testFX2 {
	 requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	   opens testFX2 to javafx.graphics;
}