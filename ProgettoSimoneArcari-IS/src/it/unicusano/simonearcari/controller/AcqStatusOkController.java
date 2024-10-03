package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneOK;

public class AcqStatusOkController {
	
	private SceneManager sceneManager;
	private StatusSceneOK statusSceneOK;
	
	public AcqStatusOkController(StatusSceneOK scene) {
		SystemLog.println("AcqStatusOkController : entered AcqStatusOkController()");
		
		statusSceneOK = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("AcqStatusOkController : entered initialize()");
		
		statusSceneOK.getBtn1().setOnAction(event -> handleBtnFIne());
		
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnFIne() {
		SystemLog.println("AcqStatusOkController : entered handleBtnFIne()");
    	
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
}
