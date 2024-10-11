package it.unicusano.simonearcari.view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public final class DashboardScene extends BaseScene {
	
	private static DashboardScene instance;	// Istanza della classe (Singleton design)
	
	// Componenti grafici
	private GridPane buttonGrid;
	private ColumnConstraints column1;
	private ColumnConstraints column2;
	private StyledButton btnRegistrazione;
	private StyledButton btnRinnovo;
	private StyledButton btnDisiscrizione;
	private StyledButton btnCalcolaRetta;
	private StyledButton btnStampaListe;

    // Costruttore
	private DashboardScene(VBox root) {
		super(root);
		
		this.setTitleText("Dashboard");
		this.setBtn1Visible(false);
		this.setBtn2Visible(false);
		
        // Griglia per i pulsanti
		this.buttonGrid = new GridPane();
		this.buttonGrid.setAlignment(Pos.CENTER);
		this.buttonGrid.setHgap(10);
		this.buttonGrid.setVgap(10);
        
        // Imposta le colonne del GridPane per espandersi uniformemente
		this.column1 = new ColumnConstraints();
		this.column1.setHgrow(Priority.ALWAYS);
		this.column1.setPercentWidth(50);  			// Imposta la colonna al 50% della larghezza totale
		this.column1.setHalignment(HPos.CENTER);  	// Centra i contenuti della colonna

		this.column2 = new ColumnConstraints();
		this.column2.setHgrow(Priority.ALWAYS);
		this.column2.setPercentWidth(50);  			// Imposta anche la seconda colonna al 50%
		this.column2.setHalignment(HPos.CENTER);

		this.buttonGrid.getColumnConstraints().addAll(column1, column2);  // Due colonne

        // Creazione dei pulsanti
        this.btnRegistrazione 	= new StyledButton("Registrazione di nuovi clienti");
        this.btnRinnovo 		= new StyledButton("Rinnovo abbonamenti");
        this.btnDisiscrizione 	= new StyledButton("Disiscrizione da attività sportive");
        this.btnCalcolaRetta 	= new StyledButton("Calcolo del costo della retta");
        this.btnStampaListe 	= new StyledButton("Stampa delle liste degli iscritti");
        
        // Aggiunta dei pulsanti alla griglia
        this.buttonGrid.add(btnRegistrazione, 0, 0, 2, 1);	// occupa 2 colonne
        this.buttonGrid.add(btnRinnovo, 0, 1);
        this.buttonGrid.add(btnDisiscrizione, 1, 1);
        this.buttonGrid.add(btnCalcolaRetta, 0, 2);
        this.buttonGrid.add(btnStampaListe, 1, 2); 

        // Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(buttonGrid);
	}
	
	// Per avere l'istanza unica
	public static DashboardScene getInstance() {
		if (instance == null) {
			instance = new DashboardScene(new VBox());
		}
		
		return instance;
	}
	
	public StyledButton getBtnRegistrazione() {
		return btnRegistrazione;
	}

	public StyledButton getBtnRinnovo() {
		return btnRinnovo;
	}

	public StyledButton getBtnDisiscrizione() {
		return btnDisiscrizione;
	}

	public StyledButton getBtnCalcolaRetta() {
		return btnCalcolaRetta;
	}

	public StyledButton getBtnStampaListe() {
		return btnStampaListe;
	}
}
