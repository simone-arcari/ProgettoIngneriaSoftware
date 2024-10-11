package it.unicusano.simonearcari.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public final class PrintListsScene extends BaseScene {
	
	private static PrintListsScene instance;
	
    private GridPane formGrid;
    private RadioButton generaleRadioButton;
    private RadioButton nuotoRadioButton;
    private RadioButton atleticaRadioButton;
    private RadioButton bodybuildingRadioButton;
    private RadioButton allClientiRadioButton;
    private ToggleGroup listaGroup;

	public PrintListsScene(VBox root) {
		super(root);
		
		this.setTitleText("Mostra Liste Iscritti");
		this.setBtn1Text("Conferma");
		this.setBtn2Text("Annulla");
		
		// Griglia per le opzioni della lista
		this.formGrid = new GridPane();
		this.formGrid.setAlignment(Pos.CENTER);
		this.formGrid.setVgap(10);

        // Gruppo di selezione per le liste
		this.listaGroup = new ToggleGroup();
		
        // Opzione Lista Generale Iscritti
		this.generaleRadioButton = new RadioButton("Lista Generale Iscritti");
		this.generaleRadioButton.setToggleGroup(listaGroup);
		this.generaleRadioButton.setSelected(true); // Selezione predefinita

        // Opzione Lista Nuoto
		this.nuotoRadioButton = new RadioButton("Lista Iscritti Nuoto");
		this.nuotoRadioButton.setToggleGroup(listaGroup);

        // Opzione Lista Atletica Leggera
		this.atleticaRadioButton = new RadioButton("Lista Iscritti Atletica Leggera");
		this.atleticaRadioButton.setToggleGroup(listaGroup);

        // Opzione Lista BodyBuilding
		this.bodybuildingRadioButton = new RadioButton("Lista Iscritti BodyBuilding");
		this.bodybuildingRadioButton.setToggleGroup(listaGroup);
		
		// Opzione tutti i clienti registrati
		this.allClientiRadioButton = new RadioButton("Lista Tutti CLienti Registrati");
		this.allClientiRadioButton.setToggleGroup(listaGroup);

        // Aggiungi le opzioni alla griglia
		this.formGrid.add(new Label("Seleziona una lista da stampare:"), 0, 0);
		this.formGrid.add(generaleRadioButton, 0, 1);
		this.formGrid.add(nuotoRadioButton, 0, 2);
		this.formGrid.add(atleticaRadioButton, 0, 3);
		this.formGrid.add(bodybuildingRadioButton, 0, 4);
		this.formGrid.add(allClientiRadioButton, 0, 5);
		
		// Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(formGrid);
	}
	
	public static PrintListsScene getInstance() {
		if (instance == null) {
			instance = new PrintListsScene(new VBox());
		}
		return instance;
	}

	public RadioButton getGeneraleRadioButton() {
		return generaleRadioButton;
	}

	public RadioButton getNuotoRadioButton() {
		return nuotoRadioButton;
	}

	public RadioButton getAtleticaRadioButton() {
		return atleticaRadioButton;
	}

	public RadioButton getBodybuildingRadioButton() {
		return bodybuildingRadioButton;
	}

	public RadioButton getAllClientiRadioButton() {
	    return allClientiRadioButton;
	}
}
