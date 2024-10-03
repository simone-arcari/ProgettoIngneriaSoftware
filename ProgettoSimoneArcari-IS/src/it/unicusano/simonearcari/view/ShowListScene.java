package it.unicusano.simonearcari.view;

import it.unicusano.simonearcari.controller.Iscritto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public final class ShowListScene extends BaseScene {
    
    private static ShowListScene instance;
    
    private TableView<Iscritto> tabellaIscritti;
    private TableColumn<Iscritto, Integer> colMatricola;
    private TableColumn<Iscritto, String> colNome;
    private TableColumn<Iscritto, String> colCognome;
    
	@SuppressWarnings("unchecked")
	private ShowListScene(VBox root) {
        super(root);
        
        this.setTitleText("Titolo Lista");
        this.setBtn1Text("Indietro");
        this.setBtn2Visible(false);
        
        // Creazione della tabella iscritti attività sportiva scelta
        this.tabellaIscritti = new TableView<>();
        
        // Creazione delle colonne
        colMatricola = new TableColumn<>("Matricola");
        colMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
        
        colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        colCognome = new TableColumn<>("Cognome");
        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        
        // Aggiunta delle colonne alla tabella
        tabellaIscritti.getColumns().addAll(colMatricola, colNome, colCognome);
        
        // Rendi le tabelle a dimensione fissa
        for (@SuppressWarnings("rawtypes") TableColumn col : tabellaIscritti.getColumns()) {
            col.setResizable(false);
        }
        
        // Dividi lo spazio per esattamente 3 colonne
        tabellaIscritti.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double tableWidth = newWidth.doubleValue();
            double col1Width = tableWidth/3;
            double col2Width = tableWidth/3;
            double col3Width = tableWidth/3;

            tabellaIscritti.getColumns().get(0).setPrefWidth(col1Width);
            tabellaIscritti.getColumns().get(1).setPrefWidth(col2Width);
            tabellaIscritti.getColumns().get(2).setPrefWidth(col3Width);
        });


        
        // Aggiunta di dati di esempio alla tabella
        ObservableList<Iscritto> items = FXCollections.observableArrayList(
                new Iscritto(1, "Nome1", "Cognome1"),
                new Iscritto(2, "Nome2", "Cognome2"),
                new Iscritto(3, "Nome3", "Cognome3")
        );
        tabellaIscritti.setItems(items);
        tabellaIscritti.getItems().clear();

        
        // Aggiunta di tutto al contenitore principale
        VBox mainContainer = this.getMainContainer();
        mainContainer.getChildren().addAll(tabellaIscritti);
    }
    
    public static ShowListScene getInstance() {
        if (instance == null) {
            instance = new ShowListScene(new VBox());
        }
        return instance;
    }

    public TableView<Iscritto> getTabellaIscritti() {
        return tabellaIscritti;
    }
}

