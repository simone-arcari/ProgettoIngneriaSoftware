package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.SelectActivityScene;

public class SelectActivityController {

	private SceneManager sceneManager;
	private SelectActivityScene selectActivityScene;
	private BridgeController bridgeController;
	private Integer currentMatricola;
	
	public SelectActivityController(SelectActivityScene scene) {
		SystemLog.println("SelectActivityController : entered SelectActivityController()");
		
		selectActivityScene = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("SelectActivityController : entered initialize()");
		
		selectActivityScene.getBtn1().setOnAction(event -> handleBtnAcquista());
		selectActivityScene.getBtn2().setOnAction(event -> handleBtnAnnulla());
		selectActivityScene.getAttivita1CheckBox().setOnAction(event -> handleBtnAcquistaCheckBox());
    	selectActivityScene.getAttivita2CheckBox().setOnAction(event -> handleBtnAcquistaCheckBox());
    	selectActivityScene.getAttivita3CheckBox().setOnAction(event -> handleBtnAcquistaCheckBox());
		
		sceneManager = SceneManager.getInstance();
		bridgeController = BridgeController.getInstance(null);
	}
	
	private void handleBtnAcquista() {
		SystemLog.println("SelectActivityController : entered handleBtnAcquista()");
    	
    	boolean nuoto = selectActivityScene.getAttivita1CheckBox().isSelected();
		boolean atletica = selectActivityScene.getAttivita2CheckBox().isSelected();
		boolean bodybuilding = selectActivityScene.getAttivita3CheckBox().isSelected();
    	
		bridgeController.setSubscription(currentMatricola, nuoto, atletica, bodybuilding);
		
		selectActivityScene.getAttivita1CheckBox().setSelected(false);
		selectActivityScene.getAttivita2CheckBox().setSelected(false);
		selectActivityScene.getAttivita3CheckBox().setSelected(false);
    	
    	sceneManager.switchTo(SceneID.STATUS_ACQ_OK);
    }
	
	private void handleBtnAnnulla() {
		SystemLog.println("SelectActivityController : entered handleBtnAnnulla()");
		
    	selectActivityScene.getAttivita1CheckBox().setSelected(false);
		selectActivityScene.getAttivita2CheckBox().setSelected(false);
		selectActivityScene.getAttivita3CheckBox().setSelected(false);
    	
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
	
	private void handleBtnAcquistaCheckBox() {
		SystemLog.println("SelectActivityController : entered handleBtnAcquistaCheckBox()");
		
		boolean nuoto = selectActivityScene.getAttivita1CheckBox().isSelected();
		boolean atletica = selectActivityScene.getAttivita2CheckBox().isSelected();
		boolean bodybuilding = selectActivityScene.getAttivita3CheckBox().isSelected();
		
		Double prezzo = bridgeController.calculatePrezzo(nuoto, atletica, bodybuilding);
		selectActivityScene.getRisultatoLabel().setText("Prezzo: " + prezzo + "€");
	}

	public Integer getCurrentMatricola() {
		SystemLog.println("SelectActivityController : entered getCurrentMatricola()");
		
		return currentMatricola;
	}

	public void setCurrentMatricola(Integer currentMatricola) {
		SystemLog.println("SelectActivityController : entered setCurrentMatricola()");
		
		this.currentMatricola = currentMatricola;
	}
}
