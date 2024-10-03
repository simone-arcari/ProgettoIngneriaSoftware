package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.RegistrationScene;

public class RegistrationController {
	
	private SceneManager sceneManager;
	private RegistrationScene registrationScene;
	private BridgeController bridgeController;
	
	public RegistrationController(RegistrationScene registration) {
		SystemLog.println("RegistrationController : entered RegistrationController()");
		
		registrationScene = registration;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("RegistrationController : entered handleBtnConferma()");
		
		registrationScene.getBtn1().setOnAction(event -> handleBtnConferma());
		registrationScene.getBtn2().setOnAction(event -> handleBtnAnnulla());
		
		sceneManager = SceneManager.getInstance();
		bridgeController = BridgeController.getInstance(null);
	}
	
	private void handleBtnConferma() {
		SystemLog.println("RegistrationController : entered handleBtnConferma()");
		
		boolean error = false;
		Integer matricola = null;
		    	
    	// Prelevo i campi del form
    	String nome = registrationScene.getNomeField().getText();
    	String cognome = registrationScene.getCognomeField().getText();
    	String matricolaStr = registrationScene.getMatricolaField().getText();
    	
    	// Pulisco i campi del form
    	registrationScene.getNomeField().setText("");
    	registrationScene.getCognomeField().setText("");
    	registrationScene.getMatricolaField().setText("");

    	SystemLog.println("nome: " + nome +" cognome: " + cognome + " matricola: " + matricolaStr);
    	
    	if (nome.isEmpty() || cognome.isEmpty() || matricolaStr.isEmpty()) {
    		error = true;
    	}
    	
    	if (matricolaStr.matches("\\d+") == true) {
    		matricola = Integer.valueOf(matricolaStr);
    		error = !(bridgeController.registerCustomer(nome, cognome, matricola));
    	}
    	else {
    		error = true;
    	}

    	if (error) {
    		sceneManager.switchTo(SceneID.STATUS_REG_ERROR); 
    	}else {
    		sceneManager.getRegStatusOkController().setCurrentMatricola(matricola);
    		sceneManager.switchTo(SceneID.STATUS_REG_OK);
    	}	
	}
	
	private void handleBtnAnnulla() {
		SystemLog.println("RegistrationController : entered handleBtnAnnulla()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
