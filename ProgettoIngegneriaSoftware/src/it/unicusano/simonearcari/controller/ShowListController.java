package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.ShowListScene;
import javafx.collections.ObservableList;

public class ShowListController {
	
	private SceneManager sceneManager;
	private ShowListScene showListScene;
	private BridgeController bridgeController;

	public ShowListController(ShowListScene scene) {
		SystemLog.println("ShowListController : entered ShowListController()");
		
		showListScene = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("ShowListController : entered initialize()");
		
		showListScene.getBtn1().setOnAction(event -> handleBtnIndietro());
		
		sceneManager = SceneManager.getInstance();
		bridgeController = BridgeController.getInstance(null);
	}
	
	private void handleBtnIndietro() {
		SystemLog.println("ShowListController : entered handleBtnIndietro()");
		
    	showListScene.getTabellaIscritti().getItems().clear();
    	
    	sceneManager.getStage().setResizable(false);
    	sceneManager.switchTo(SceneID.PRINT_LISTS);
    }
	
	public void selctList(boolean generale, boolean nuoto, boolean atletica, boolean bodybuilding, boolean all) {
		SystemLog.println("ShowListController : entered selctList()");
		
		ObservableList<Iscritto> items = null;
				
		if (generale) {
			showListScene.setTitleText("Lista degli Iscritti Generale");
			items = bridgeController.getIscrittiGenerale();
		}
		else if (nuoto) {
			showListScene.setTitleText("Lista degli Iscritti Nuoto");
			items = bridgeController.getIscrittiNuoto();
		}
		else if (atletica) {
			showListScene.setTitleText("Lista degli Iscritti Atletica");
			items = bridgeController.getIscrittiAtletica();
		}
		else if (bodybuilding) {
			showListScene.setTitleText("Lista degli Iscritti Bodybuilding");
			items = bridgeController.getIscrittiBodybuilding();
		}
		else if (all) {
			showListScene.setTitleText("Lista Clienti Registrati");
			items = bridgeController.getAllRegisterdCustomers();
		}
		
		if (items != null) {
			showListScene.getTabellaIscritti().setItems(items);			
		}
	}
}
