package it.unicusano.simonearcari.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public final class RegistrationScene extends BaseScene {
	
	private static RegistrationScene instance;
	    
	// Componenti grafici
    private GridPane formGrid;
    private TextField nomeField;
    private TextField cognomeField;
    private TextField matricolaField;
	
	private RegistrationScene(VBox root) {
		super(root);
		
		this.setTitleText("Registrazione Nuovo Cliente");
		this.setBtn1Text("Conferma");
		this.setBtn2Text("Annulla");
		
		// Griglia per i campi del modulo
        this.formGrid = new GridPane();
        this.formGrid.setAlignment(Pos.CENTER);
        this.formGrid.setVgap(10);
		
		// Campi del modulo di inserimento
		this.nomeField = new TextField();
		this.nomeField.setPromptText("Nome");
		this.cognomeField = new TextField();
		this.cognomeField.setPromptText("Cognome");
		this.matricolaField = new TextField();
		this.matricolaField.setPromptText("Matricola");

		this.formGrid.add(new Label("Nome:"), 0, 0);
		this.formGrid.add(nomeField, 1, 0);
		this.formGrid.add(new Label("Cognome:"), 0, 1);
		this.formGrid.add(cognomeField, 1, 1);
		this.formGrid.add(new Label("Matricola:"), 0, 2);
		this.formGrid.add(matricolaField, 1, 2);
        
        // Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(formGrid);
		
	}
	
	public static RegistrationScene getInstance() {
		if (instance == null) {
			instance = new RegistrationScene(new VBox());
		}
		return instance;
	}

	public TextField getNomeField() {
		return nomeField;
	}

	public TextField getCognomeField() {
		return cognomeField;
	}

	public TextField getMatricolaField() {
		return matricolaField;
	}
	
	
}
