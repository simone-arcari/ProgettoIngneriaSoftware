package it.unicusano.simonearcari.view;

import javafx.scene.control.Button;

public class StyledButton extends Button{
	public StyledButton(String text) {
		super(text);
		
		this.setMaxWidth(Double.MAX_VALUE);
		
		this.setStyle(	"-fx-padding: 15px;" +
                		"-fx-font-size: 16px;" +
                		"-fx-text-fill: #fff;" +
                		"-fx-background-color: #007bff;" +
                		"-fx-border-radius: 5px;" +
                		"-fx-background-radius: 5px;");
		
		this.setOnMouseEntered(e -> this.setStyle(	"-fx-background-color: #0056b3;" +
                                              		"-fx-padding: 15px;" +
                                              		"-fx-font-size: 16px;" +
                                              		"-fx-text-fill: #fff;" +
                                              		"-fx-border-radius: 5px;" +
                                              		"-fx-background-radius: 5px;"));

		this.setOnMouseExited(e -> this.setStyle(	"-fx-background-color: #007bff;" +
                                             		"-fx-padding: 15px;" +
                                             		"-fx-font-size: 16px;" +
                                             		"-fx-text-fill: #fff;" +
                                             		"-fx-border-radius: 5px;" +
                                             		"-fx-background-radius: 5px;"));
	}
}
