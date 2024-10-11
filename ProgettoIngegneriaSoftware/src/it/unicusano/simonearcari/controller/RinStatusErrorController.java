package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneError;

public class RinStatusErrorController {
	
	private SceneManager sceneManager;
	private StatusSceneError statusSceneError;
	
	public RinStatusErrorController(StatusSceneError scene) {
		SystemLog.println("RinStatusErrorController : entered RinStatusErrorController()");
		
		statusSceneError = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("RinStatusErrorController : entered initialize()");
		
		statusSceneError.getBtn1().setOnAction(event -> handleBtnFIne());
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnFIne() {
		SystemLog.println("RinStatusErrorController : entered handleBtnFIne()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
