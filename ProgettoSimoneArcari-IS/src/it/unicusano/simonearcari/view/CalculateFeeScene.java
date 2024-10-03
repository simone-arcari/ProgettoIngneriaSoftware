package it.unicusano.simonearcari.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public final class CalculateFeeScene extends BaseScene {
	
	private static CalculateFeeScene instance;
	
	private GridPane formGrid;
    private TextField matricolaField;
    private CheckBox attivita1CheckBox;
    private CheckBox attivita2CheckBox;
    private CheckBox attivita3CheckBox;
    private Label prezzoCalcLabel;
    private Label prezzoAbbLabel;

	private CalculateFeeScene(VBox root) {
		super(root);
		
		this.setTitleText("Calcola Retta Mensile");
		this.setBtn1Text("Conferma");
		this.setBtn2Text("Annulla");

		// Griglia per i campi del modulo
        this.formGrid = new GridPane();
        this.formGrid.setAlignment(Pos.CENTER);
        this.formGrid.setVgap(10);

        // Campo per la matricola
        this.matricolaField = new TextField();
        this.matricolaField.setPromptText("Matricola");

        // Checkbox per le attività
        this.attivita1CheckBox = new CheckBox("Nuoto");
        this.attivita2CheckBox = new CheckBox("Atletica Leggera");
        this.attivita3CheckBox = new CheckBox("BodyBuilding");

        // Label per i prezzi
        this.prezzoCalcLabel = new Label("Prezzo calcolato: 0.0 €");
        this.prezzoAbbLabel = new Label("Prezzo abbonamento attuale: 0.0 €");
        this.prezzoCalcLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #333;");
        this.prezzoAbbLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #333;");
        
        this.prezzoAbbLabel.setVisible(false);

        // Aggiungi al container
        this.formGrid.add(new Label("Matricola:"), 0, 0);
        this.formGrid.add(matricolaField, 1, 0);
        this.formGrid.add(new Label("Seleziona le attività:"), 0, 1);
        this.formGrid.add(attivita1CheckBox, 0, 2);
        this.formGrid.add(attivita2CheckBox, 0, 3);
        this.formGrid.add(attivita3CheckBox, 0, 4);
        this.formGrid.add(prezzoCalcLabel, 0, 5, 2, 1);
        this.formGrid.add(prezzoAbbLabel, 0, 6, 2, 1); 
        
        // Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(formGrid);
	}
	
	public static CalculateFeeScene getInstance() {
		if (instance == null) {
			instance = new CalculateFeeScene(new VBox());
		}
		return instance;
	}

	public TextField getMatricolaField() {
		return matricolaField;
	}

	public CheckBox getAttivita1CheckBox() {
		return attivita1CheckBox;
	}

	public CheckBox getAttivita2CheckBox() {
		return attivita2CheckBox;
	}

	public CheckBox getAttivita3CheckBox() {
		return attivita3CheckBox;
	}

	public Label getPrezzoAbbLabel() {
		return prezzoAbbLabel;
	}

	public Label getPrezzoCalcLabel() {
		return prezzoCalcLabel;
	}

	public void setPrezzoCalcLabel(Label prezzoCalcLabel) {
		this.prezzoCalcLabel = prezzoCalcLabel;
	}
}
