package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.RenewalScene;

public class RenewalController {
	
	private SceneManager sceneManager;
	private RenewalScene renewalScene;
	private BridgeController bridgeController;
	
	public RenewalController(RenewalScene renewal) {
		SystemLog.println("RenewalController : entered RenewalController()");
		
		renewalScene = renewal;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("RenewalController : entered initialize()");
		
		renewalScene.getBtn1().setOnAction(event -> handleBtnConferma());
		renewalScene.getBtn2().setOnAction(event -> handleBtnAnnulla());
		
		sceneManager = SceneManager.getInstance();
		bridgeController = BridgeController.getInstance(null);
	}
	
	private void handleBtnConferma() {
		SystemLog.println("RenewalController : entered handleBtnConferma()");
		
		boolean error = false;
		Integer matricola = null;
		    	
    	// Prelevo i campi del form
    	String matricolaStr = renewalScene.getMatricolaField().getText();
    	
    	// Pulisco i campi del form
    	renewalScene.getMatricolaField().setText("");
    	
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
    		sceneManager.switchTo(SceneID.STATUS_RIN_ERROR);
    	}
    	else {
    		sceneManager.getSelectActivityController().setCurrentMatricola(matricola);
    		sceneManager.switchTo(SceneID.SELECT_ACTIVITY);    		
    	}
    }
	
	private void handleBtnAnnulla() {
		SystemLog.println("RenewalController : entered handleBtnAnnulla()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
