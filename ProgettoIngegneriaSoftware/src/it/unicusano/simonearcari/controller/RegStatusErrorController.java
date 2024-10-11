package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneError;

public class RegStatusErrorController {
	
	private SceneManager sceneManager;
	private StatusSceneError statusSceneError;
	
	public RegStatusErrorController(StatusSceneError scene) {
		SystemLog.println("RegStatusErrorController : entered RegStatusErrorController()");
		
		statusSceneError = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("RegStatusErrorController : entered initialize()");
		
		statusSceneError.getBtn1().setOnAction(event -> handleBtnPRA());
		statusSceneError.getBtn2().setOnAction(event -> handleBtnFIne());
		
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnPRA() {
		SystemLog.println("RegStatusErrorController : entered handleBtnPRA()");
		
    	sceneManager.switchTo(SceneID.RENEWAL);
	}
	
	private void handleBtnFIne() {
		SystemLog.println("RegStatusErrorController : entered handleBtnFIne()");

    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
