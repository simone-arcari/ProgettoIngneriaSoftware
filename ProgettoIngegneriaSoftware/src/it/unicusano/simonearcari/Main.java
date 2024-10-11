package it.unicusano.simonearcari;
	
import it.unicusano.simonearcari.controller.SceneID;
import it.unicusano.simonearcari.controller.SceneManager;
import it.unicusano.simonearcari.model.SystemManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		SystemLog.println("Main : entered start()");
		
		try {			
			
			// Gestisce il modello dei dati e il relativo DataBase
			SystemManager systemManager = SystemManager.getInstance();
			
			// Gestore della grafica
			SceneManager sceneManager = SceneManager.getInstance(stage);

	    	
	    	Image icon = new Image("logo.png");
			
			sceneManager.switchTo(SceneID.DASHBOARD);
			stage.setTitle("simonearcari.unicusano.it");
			stage.getIcons().add(icon);
			stage.setResizable(false);
			stage.setX(0);
			stage.setY(0);
			stage.show();
			
			// Gestore per l'evento di chiusura
	        stage.setOnCloseRequest(event -> {      	
	        	systemManager.closeDataBase();
	        	SystemLog.println("End Program");
	        });
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SystemLog.setActive(true);
		SystemLog.println("Start Program()");
			
		launch(args);
	}
}
