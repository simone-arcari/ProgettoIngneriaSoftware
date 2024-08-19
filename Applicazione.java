// [COMPILA CON]: javac --module-path javafx-sdk-22.0.2/lib --add-modules javafx.controls,javafx.web Applicazione.java
// [ESEGUI CON]: java --module-path javafx-sdk-22.0.2/lib --add-modules javafx.controls,javafx.web Applicazione
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.File;

public class Applicazione extends Application {

    @Override
    public void start(Stage primaryStage) {
        /*
         * L'oggetto WebView in JavaFX è un componente UI che consente di visualizzare contenuti web all'interno di un'applicazione JavaFX. 
         * In altre parole, WebView è un componente che può rendere e visualizzare pagine HTML, CSS e JavaScript come se fosse un browser web incorporato.
         */
        
        WebView webView = new WebView();

        /*
         * WebEngine è una classe di JavaFX che fa parte del pacchetto javafx.scene.web. 
         * Essa fornisce le funzionalità principali per caricare e gestire contenuti web all'interno di un componente WebView. 
         * In sostanza, WebEngine è il motore di rendering che elabora e visualizza le pagine web nel componente WebView.
         */
        WebEngine webEngine = webView.getEngine();

        // Carica il file HTML
        File htmlFile = new File("GUI/index.html");
        webEngine.load(htmlFile.toURI().toString());
        //loadHTML("GUI/index.html");

        // Imposta il bridge dopo il caricamento della pagina
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState.toString().equals("SUCCEEDED")) {
                System.out.println("Page loaded successfully, bridge should be set.");
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("javaApp", new JavaBridge());
            }
        });

        /*
         * BorderPane è una classe di layout in JavaFX che ti consente di organizzare i nodi all'interno di una finestra o scena in cinque aree principali: 
         * superiore, inferiore, sinistra, destra e centro. 
         * Questo tipo di layout è molto utile per creare interfacce utente con un'organizzazione chiara e strutturata.
         * In questo codice serve come un contenitore principale per organizzare e gestire la disposizione della WebView e di altri componenti dell'interfaccia utente
         */
        BorderPane root = new BorderPane(); // 
        root.setCenter(webView);

        /*
         * In JavaFX, una Scene rappresenta un contenitore per tutti gli elementi dell'interfaccia utente che vengono visualizzati all'interno di una finestra (Stage). 
         * È essenzialmente il contesto in cui si trova il layout e tutti i nodi grafici che compongono l'interfaccia utente. 
         * Una Scene può essere considerata come il contenitore principale che gestisce la visualizzazione e l'interazione con i componenti dell'interfaccia utente in una finestra dell'applicazione.
         */
        Scene scene = new Scene(root, 800, 600);

        /*
         * In JavaFX, un Stage rappresenta una finestra dell'applicazione, ovvero l'elemento principale della GUI (interfaccia utente grafica) che contiene una Scene. 
         * Ogni Stage può contenere solo una Scene alla volta, ma è possibile cambiare la Scene visualizzata per mostrare contenuti diversi.
         */
        primaryStage.setTitle("Simone Arcari Progetto Ingegneria del Software");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Classe interna per gestire le chiamate JavaScript
    public class JavaBridge {
        public void loadRegistrazione() {
            System.out.println("javaApp->loadRegistrazione()");
        }

        public void tornaDashboard() {
            System.out.println("javaApp->tornaDashboard()");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
