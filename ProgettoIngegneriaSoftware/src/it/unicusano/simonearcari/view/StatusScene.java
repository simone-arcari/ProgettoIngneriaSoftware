package it.unicusano.simonearcari.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StatusScene extends BaseScene {
	
	// Componenti grafici	
	private ImageView icon;
	private Image image; 

	// Costruttore
	public StatusScene(VBox root) {
		super(root);
		
		icon = new ImageView();
		icon.setFitHeight(100);
		icon.setFitWidth(100);
		
		VBox mainContainer = this.getMainContainer();
		mainContainer.getChildren().add(icon);
	}
	
	public ImageView getIcon() {
		return icon;
	}

	public void setIcon(ImageView icon) {
		this.icon = icon;
	}
	
	public void setImage(String filename) {
	    image = new Image(filename);	// Crea l'oggetto Image con il file specificato
	    icon.setImage(image);			// Imposta l'immagine sull'ImageView
	}
}
