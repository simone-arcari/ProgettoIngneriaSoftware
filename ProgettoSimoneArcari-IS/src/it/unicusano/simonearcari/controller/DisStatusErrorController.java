package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneError;

public class DisStatusErrorController {
	
	private SceneManager sceneManager;
	private StatusSceneError statusSceneError;
	
	public DisStatusErrorController(StatusSceneError scene) {
		SystemLog.println("DisStatusErrorController : entered DisStatusErrorController()");
		
		statusSceneError = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("DisStatusErrorController : entered initialize()");
		
		statusSceneError.getBtn1().setOnAction(event -> handleBtnFIne());
		
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnFIne() {
		SystemLog.println("DisStatusErrorController : entered handleBtnFIne()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
