package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneOK;

public class DisStatusOkController {
	
	private SceneManager sceneManager;
	private StatusSceneOK statusSceneOK;
	
	public DisStatusOkController(StatusSceneOK scene) {
		SystemLog.println("DisStatusOkController : entered DisStatusOkController()");
		
		statusSceneOK = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("DisStatusOkController : entered initialize()");
		
		statusSceneOK.getBtn1().setOnAction(event -> handleBtnFIne());
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnFIne() {
		SystemLog.println("DisStatusOkController : entered handleBtnFIne()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
