package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.StatusSceneOK;

public class RegStatusOkController {
	
	private SceneManager sceneManager;
	private StatusSceneOK statusSceneOK;
	private Integer currentMatricola;
	
	public RegStatusOkController(StatusSceneOK scene) {
		SystemLog.println("RegStatusOkController : entered RegStatusOkController()");
		
		statusSceneOK = scene;
		initialize();
	}
	
	private void initialize() {
		SystemLog.println("RegStatusOkController : entered initialize()");
		
		statusSceneOK.getBtn1().setOnAction(event -> handleBtnSAS());
		statusSceneOK.getBtn2().setOnAction(event -> handleBtnFIne());
		
		sceneManager = SceneManager.getInstance();
	}
	
	private void handleBtnSAS() {
		SystemLog.println("RegStatusOkController : entered handleBtnSAS()");
		
    	sceneManager.getSelectActivityController().setCurrentMatricola(currentMatricola);
    	sceneManager.switchTo(SceneID.SELECT_ACTIVITY);
    }
	
	private void handleBtnFIne() {
		SystemLog.println("RegStatusOkController : entered handleBtnFIne()");
		
    	sceneManager.switchTo(SceneID.DASHBOARD);
    }
	
	public Integer getCurrentMatricola() {
		SystemLog.println("RegStatusOkController : entered getCurrentMatricola()");
		
		return currentMatricola;
	}

	public void setCurrentMatricola(Integer currentMatricola) {
		SystemLog.println("RegStatusOkController : entered setCurrentMatricola()");
		
		this.currentMatricola = currentMatricola;
	}
}
