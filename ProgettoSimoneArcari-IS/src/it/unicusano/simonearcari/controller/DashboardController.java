package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.DashboardScene;

public class DashboardController {
	
	private SceneManager sceneManager;
    private DashboardScene dashboardScene;

    public DashboardController(DashboardScene dashboard) {
		SystemLog.println("DashboardController : entered DashboardController()");
		
        dashboardScene = dashboard;
        initialize();
    }

    private void initialize() {
		SystemLog.println("DashboardController : entered initialize()");
		
    	dashboardScene.getBtnRegistrazione().setOnAction(event -> handleBtnRegistrazioneClick());
    	dashboardScene.getBtnRinnovo().setOnAction		(event -> handleBtnRinnovoClick());
    	dashboardScene.getBtnDisiscrizione().setOnAction(event -> handleBtnDisiscrizioneClick());  	
    	dashboardScene.getBtnCalcolaRetta().setOnAction	(event -> handleBtnCalcolaRettaClick());
    	dashboardScene.getBtnStampaListe().setOnAction	(event -> handleBtnStampaListeClick());
    	
    	sceneManager = SceneManager.getInstance();
    }

    public void handleBtnRegistrazioneClick() {
		SystemLog.println("DashboardController : entered handleBtnRegistrazioneClick()");
		
    	sceneManager.switchTo(SceneID.REGISTRATION);
    }
    
    public void handleBtnRinnovoClick() {
		SystemLog.println("DashboardController : entered handleBtnRinnovoClick()");
		
    	sceneManager.switchTo(SceneID.RENEWAL);
    }
    
    public void handleBtnDisiscrizioneClick() {
		SystemLog.println("DashboardController : entered handleBtnDisiscrizioneClick()");
		
    	sceneManager.switchTo(SceneID.UNSUBSCRIBE);
    }
    
    public void handleBtnCalcolaRettaClick() {
		SystemLog.println("DashboardController : entered handleBtnCalcolaRettaClick()");
		
    	sceneManager.switchTo(SceneID.CALCULATE_FEE);
    }
    
    public void handleBtnStampaListeClick() {
		SystemLog.println("DashboardController : entered handleBtnStampaListeClick()");
		
    	sceneManager.switchTo(SceneID.PRINT_LISTS);
    }
}
