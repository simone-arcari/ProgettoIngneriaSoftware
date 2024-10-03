module HelloWorldJavaFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	
	opens it.unicusano.simonearcari to javafx.graphics, javafx.fxml;
	opens it.unicusano.simonearcari.controller to javafx.base;

}
