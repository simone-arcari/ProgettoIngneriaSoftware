package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.PrintListsScene;

public class PrintListsController {
	
	private SceneManager sceneManager;
	private PrintListsScene printListsScene;
	
	public PrintListsController(PrintListsScene showLists) {
		SystemLog.println("PrintListsController : entered PrintListsController()");
		
		printListsScene = showLists;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("PrintListsController : entered initialize()");
		
		printListsScene.getBtn1().setOnAction(event -> handleBtnConferma());
		printListsScene.getBtn2().setOnAction(event -> handleBtnAnnulla());
		
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnConferma() {
		SystemLog.println("PrintListsController : entered handleBtnConferma()");
		
    	boolean generale = printListsScene.getGeneraleRadioButton().isSelected();
    	boolean nuoto = printListsScene.getNuotoRadioButton().isSelected();
    	boolean atletica = printListsScene.getAtleticaRadioButton().isSelected();
    	boolean bodybuilding = printListsScene.getBodybuildingRadioButton().isSelected();
    	boolean all = printListsScene.getAllClientiRadioButton().isSelected();
    	   	
    	sceneManager.getShowListController().selctList(generale, nuoto, atletica, bodybuilding, all);
    	  	
    	sceneManager.getStage().setResizable(true);
    	sceneManager.switchTo(SceneID.SHOW_LIST);
    }
	
	private void handleBtnAnnulla() {
		SystemLog.println("PrintListsController : entered handleBtnAnnulla()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
