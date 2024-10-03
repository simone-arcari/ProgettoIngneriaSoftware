package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.CalculateFeeScene;
import javafx.scene.control.Label;

public class CalculateFeeController {
	
	private SceneManager sceneManager;
	private CalculateFeeScene calculateFeeScene;
	private BridgeController bridgeController;
	
	public CalculateFeeController(CalculateFeeScene scene) {
		SystemLog.println("CalculateFeeController : entered CalculateFeeController()");
		
		calculateFeeScene = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("CalculateFeeController : entered initialize()");
		
		calculateFeeScene.getBtn1().setOnAction(event -> handleBtnConferma());
		calculateFeeScene.getBtn2().setOnAction(event -> handleBtnAnnulla());
		calculateFeeScene.getAttivita1CheckBox().setOnAction(event -> handleBtnAcquistaCheckBox());
		calculateFeeScene.getAttivita2CheckBox().setOnAction(event -> handleBtnAcquistaCheckBox());
		calculateFeeScene.getAttivita3CheckBox().setOnAction(event -> handleBtnAcquistaCheckBox());
		
		
		sceneManager = SceneManager.getInstance();
		bridgeController = BridgeController.getInstance(null);
	}
	
	private void handleBtnConferma() {
		SystemLog.println("CalculateFeeController : entered handleBtnConferma()");
		
		boolean error = false;
		Integer matricola = null;
		
    	System.out.println("Rinnovo Conferma");
    	
    	// Prelevo i campi del form
    	String matricolaStr = calculateFeeScene.getMatricolaField().getText();
    	
    	// Pulisco i campi del form
    	calculateFeeScene.getMatricolaField().setText("");
    	
    	System.out.println("matricola: " + matricolaStr);
    	
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
    		calculateFeeScene.getPrezzoAbbLabel().setVisible(false);
    		sceneManager.switchTo(SceneID.STATUS_MAT_WARNING);
    	}
    	else {
    		Double prezzo = bridgeController.getPrezzo(matricola);
    		Label prezzoLabel = calculateFeeScene.getPrezzoAbbLabel();
    		
    		prezzoLabel.setText("Prezzo abbonamento attuale: " + prezzo + " €");
    		prezzoLabel.setVisible(true);
    	}
    }
	
	private void handleBtnAnnulla() {
		SystemLog.println("CalculateFeeController : entered handleBtnAnnulla()");
		
    	calculateFeeScene.getPrezzoAbbLabel().setVisible(false);
    	
    	calculateFeeScene.getAttivita1CheckBox().setSelected(false);
    	calculateFeeScene.getAttivita2CheckBox().setSelected(false);
    	calculateFeeScene.getAttivita3CheckBox().setSelected(false);
    	
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
	
	private void handleBtnAcquistaCheckBox() {
		SystemLog.println("CalculateFeeController : entered handleBtnAcquistaCheckBox()");
		
		boolean nuoto = calculateFeeScene.getAttivita1CheckBox().isSelected();
		boolean atletica = calculateFeeScene.getAttivita2CheckBox().isSelected();
		boolean bodybuilding = calculateFeeScene.getAttivita3CheckBox().isSelected();
		
		Double prezzo = bridgeController.calculatePrezzo(nuoto, atletica, bodybuilding);
		calculateFeeScene.getPrezzoCalcLabel().setText("Prezzo calcolato: " + prezzo + "€");
	}
}
