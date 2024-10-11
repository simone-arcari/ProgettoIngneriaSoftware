package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneWarning;

public class MatStatusWarningController {
	
	private SceneManager sceneManager;
	private StatusSceneWarning statusSceneWarning;
	
	public MatStatusWarningController(StatusSceneWarning scene) {
		SystemLog.println("MatStatusWarningController : entered MatStatusWarningController()");
		
		statusSceneWarning = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("MatStatusWarningController : entered initialize()");
		
		statusSceneWarning.getBtn1().setOnAction(event -> handleBtnFIne());
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnFIne() {
		SystemLog.println("MatStatusWarningController : entered handleBtnFIne()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
