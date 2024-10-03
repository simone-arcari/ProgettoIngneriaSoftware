package it.unicusano.simonearcari.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public final class SelectActivityScene extends BaseScene{

	private static SelectActivityScene instance;
	
	private GridPane formGrid;
    private CheckBox attivita1CheckBox;
    private CheckBox attivita2CheckBox;
    private CheckBox attivita3CheckBox;
    private Label risultatoLabel;
	
	public SelectActivityScene(VBox root) {
		super(root);
		
		this.setTitleText("Seleziona Attività Sportive");
		this.setBtn1Text("Acquista");
		this.setBtn2Text("Annulla");
		
		// Griglia per i campi del modulo
        this.formGrid = new GridPane();
        this.formGrid.setAlignment(Pos.CENTER);
        this.formGrid.setVgap(10);
        
        // Checkbox per le attività
        this.attivita1CheckBox = new CheckBox("Nuoto");
        this.attivita2CheckBox = new CheckBox("Atletica Leggera");
        this.attivita3CheckBox = new CheckBox("BodyBuilding");
        
        this.formGrid.add(new Label("Seleziona le attività:"), 0, 0);
        this.formGrid.add(attivita1CheckBox, 0, 1);
        this.formGrid.add(attivita2CheckBox, 0, 2);
        this.formGrid.add(attivita3CheckBox, 0, 3);
        
        // Label per il risultato
        this.risultatoLabel = new Label("Prezzo: 0.0 €");
        this.risultatoLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #333;");
        this.formGrid.add(risultatoLabel, 0, 5, 2, 1); // Aggiunta della label del risultato
        
        // Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(formGrid);
	}
	
	public static SelectActivityScene getInstance() {
		if (instance == null) {
			instance = new SelectActivityScene(new VBox());
		}
		return instance;
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

	public Label getRisultatoLabel() {
		return risultatoLabel;
	}

	
}
