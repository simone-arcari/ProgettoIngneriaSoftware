package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.UnsubscribeScene;

public class UnsubscribeController {
	
	private SceneManager sceneManager;
	private UnsubscribeScene unsubscribeScene;
	private BridgeController bridgeController;
	
	public UnsubscribeController(UnsubscribeScene unsubscribe) {
		SystemLog.println("UnsubscribeController : entered UnsubscribeController()");
		
		unsubscribeScene = unsubscribe;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("UnsubscribeController : entered initialize()");
		
		unsubscribeScene.getBtn1().setOnAction(event -> handleBtnConferma());
		unsubscribeScene.getBtn2().setOnAction(event -> handleBtnAnnulla());
		
		sceneManager = SceneManager.getInstance();
		bridgeController = BridgeController.getInstance(null);
	}
	
	private void handleBtnConferma() {
		SystemLog.println("UnsubscribeController : entered handleBtnConferma()");
		
		boolean error = false;
		Integer matricola = null;
		    	
    	// Prelevo i campi del form
    	String matricolaStr = unsubscribeScene.getMatricolaField().getText();
    	
    	// Pulisco i campi del form
    	unsubscribeScene.getMatricolaField().setText("");
    	
    	SystemLog.println("matricola: " + matricolaStr);
    	
    	if (matricolaStr.isEmpty()) {
    		error = true;
    	}
    	else {
    		if (matricolaStr.matches("\\d+") == true) {
        		matricola = Integer.valueOf(matricolaStr);
        		error = !(bridgeController.findMatricola(matricola));
        	}
        	else {
        		error = true;
        	}
    	}
	
    	if (error) {
    		sceneManager.switchTo(SceneID.STATUS_DIS_ERROR);
    	}
    	else {
    		bridgeController.setSubscription(matricola, false, false, false);
    		sceneManager.switchTo(SceneID.STATUS_DIS_OK);    		
    	}
    }
	
	private void handleBtnAnnulla() {
		SystemLog.println("UnsubscribeController : entered handleBtnAnnulla()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}