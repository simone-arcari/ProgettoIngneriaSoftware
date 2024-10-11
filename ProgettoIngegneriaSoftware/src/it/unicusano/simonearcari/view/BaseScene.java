package it.unicusano.simonearcari.view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BaseScene extends Scene {
	
	private static final Integer width = 600;	// Larghezza finestra in pixel
	private static final Integer height = 500;	// Altezza finestra in pixel
	
	// Componenti grafici
	private VBox rootContainer;
	private Label title;
	private VBox mainContainer;
	private GridPane buttonGrid;
	private ColumnConstraints column1;
	private ColumnConstraints column2;
	private StyledButton btn1;
	private StyledButton btn2;

	// Costruttore
	public BaseScene(VBox root) {
		super(root, width, height);
		rootContainer = root;
		setContent();		
	}
	
	// Crea il contenuto grafico
	private void setContent() {
		Integer spacing = 20;
		
        // Contenitore principale
		rootContainer.setSpacing(spacing);
        rootContainer.setAlignment(Pos.CENTER);
        rootContainer.setStyle(	"-fx-padding: 20;" +
                           		"-fx-background-color: #fff;" +
                           		"-fx-border-radius: 8px;" +
                           		"-fx-background-radius: 8px;" +
                           		"-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 10, 0, 0, 0);" +
                           		"-fx-max-width: 400px;" +
                           		"-fx-min-width: 300px;");

        // Titolo
        title = new Label("Titolo");
        title.setStyle("-fx-font-size: 36px;" +
                       "-fx-font-weight: bold;" +
                       "-fx-text-fill: #333;");
        
        // Contenitore principale
        mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);
        
        // Griglia per i pulsanti
        buttonGrid = new GridPane();
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setHgap(10);  // Spazio orizzontale tra i pulsanti
        buttonGrid.setVgap(10);  // Spazio verticale (se necessario)

        // Imposta le colonne del GridPane per espandersi uniformemente
        column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        column1.setPercentWidth(50);  			// Imposta la colonna al 50% della larghezza totale
        column1.setHalignment(HPos.CENTER);  	// Centra i contenuti della colonna

        column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        column2.setPercentWidth(50);  			// Imposta anche la seconda colonna al 50%
        column2.setHalignment(HPos.CENTER);

        buttonGrid.getColumnConstraints().addAll(column1, column2);  // Due colonne

        // Pulsanti
        btn1 = new StyledButton("Pulsante 1");
        btn2 = new StyledButton("Pulsante 2");

        // Aggiunta dei pulsanti alla griglia
        buttonGrid.add(btn1, 0, 0);  // Pulsante a sinistra (prima colonna)
        buttonGrid.add(btn2, 1, 0);  // Pulsante a destra (seconda colonna)

        // Aggiunta di tutto al contenitore principale
        rootContainer.getChildren().addAll(title, mainContainer, buttonGrid);
    }
	
	public void setBtn1Visible(boolean visibility) {
		this.btn1.setVisible(visibility);
		
		if (this.btn2.isVisible()) {
			if (visibility) {
				this.column1.setPercentWidth(50);
				this.column2.setPercentWidth(50);
			}
			else {
				this.column1.setPercentWidth(0);
				this.column2.setPercentWidth(100);
			}
		}
		else {
			if (visibility) {
				this.column1.setPercentWidth(100);
				this.column2.setPercentWidth(0);
			}
			else {
				this.column1.setPercentWidth(0);
				this.column2.setPercentWidth(0);
			}
		}
	}
	
	public void setBtn2Visible(boolean visibility) {
		this.btn2.setVisible(visibility);
		
		if (this.btn1.isVisible()) {
			if (visibility) {
				this.column1.setPercentWidth(50);
				this.column2.setPercentWidth(50);
			}
			else {
				this.column1.setPercentWidth(100);
				this.column2.setPercentWidth(0);
			}
		}
		else {
			if (visibility) {
				this.column1.setPercentWidth(0);
				this.column2.setPercentWidth(100);
			}
			else {
				this.column1.setPercentWidth(0);
				this.column2.setPercentWidth(0);
			}
		}
	}
	
	public void setTitleText(String text) {
		this.title.setText(text);
	}
	
	public void setBtn1Text(String text) {
		this.btn1.setText(text);
	}
	
	public void setBtn2Text(String text) {
		this.btn2.setText(text);
	}
	
	public VBox getRootContainer() {
		return rootContainer;
	}

	public void setRootContainer(VBox container) {
		this.rootContainer = container;
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public VBox getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(VBox mainContainer) {
		this.mainContainer = mainContainer;
	}

	public GridPane getButtonGrid() {
		return buttonGrid;
	}

	public void setButtonGrid(GridPane buttonGrid) {
		this.buttonGrid = buttonGrid;
	}

	public StyledButton getBtn1() {
		return btn1;
	}

	public void setBtn1(StyledButton btn) {
		this.btn1 = btn;
	}

	public StyledButton getBtn2() {
		return btn2;
	}

	public void setBtn2(StyledButton btn) {
		this.btn2 = btn;
	}
}
