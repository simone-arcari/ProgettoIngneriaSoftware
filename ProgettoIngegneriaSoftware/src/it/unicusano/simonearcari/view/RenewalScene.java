package it.unicusano.simonearcari.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public final class RenewalScene extends BaseScene {
	
	private static RenewalScene instance;
	
    private GridPane formGrid;
    private TextField matricolaField;
    
	public RenewalScene(VBox root) {
		super(root);
		
		this.setTitleText("Rinnovo Abbonamenti");
		this.setBtn1Text("Conferma");
		this.setBtn2Text("Annulla");
		
		// Griglia per i campi del modulo
        this.formGrid = new GridPane();
        this.formGrid.setAlignment(Pos.CENTER);
        this.formGrid.setVgap(10);

        // Campo per la matricola
        this.matricolaField = new TextField();
        this.matricolaField.setPromptText("Matricola");

        this.formGrid.add(new Label("Matricola:"), 0, 0);
        this.formGrid.add(matricolaField, 1, 0);
        
        // Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(formGrid);
	}
	
	public static RenewalScene getInstance() {
		if (instance == null) {
			instance = new RenewalScene(new VBox());
		}
		return instance;
	}

	public TextField getMatricolaField() {
		return matricolaField;
	}
}
