package it.unicusano.simonearcari.controller;

import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.HashMap;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.CalculateFeeScene;
import it.unicusano.simonearcari.view.DashboardScene;
import it.unicusano.simonearcari.view.PrintListsScene;
import it.unicusano.simonearcari.view.RegistrationScene;
import it.unicusano.simonearcari.view.RenewalScene;
import it.unicusano.simonearcari.view.SelectActivityScene;
import it.unicusano.simonearcari.view.ShowListScene;
import it.unicusano.simonearcari.view.StatusSceneError;
import it.unicusano.simonearcari.view.StatusSceneOK;
import it.unicusano.simonearcari.view.StatusSceneWarning;
import it.unicusano.simonearcari.view.UnsubscribeScene;

public class SceneManager {
	private static SceneManager instance;
	
	// Controllor scena primaria
	private static DashboardController 			dashboardController;		//	#1
	// Controllor scene secondarie 
	private static RegistrationController 		registrationController;		//	#2
	private static RenewalController 			renewalController;			//	#3
	private static UnsubscribeController 		unsubscribeController;		//	#4
	private static CalculateFeeController 		calculateFeeController;		//	#5
	private static PrintListsController 		printListsController;		//	#6
	// Controllor scene intermedie
	private static SelectActivityController		selectActivityController;	//	#7
	private static ShowListController			showListController;			//	#8
	// Controller scene terziarie
	private static RegStatusOkController 		regStatusOkController;		//	#9
	private static DisStatusOkController 		disStatusOkController;		//	#10
	private static AcqStatusOkController 		acqStatusOkController;		//	#11
	private static RegStatusErrorController 	regStatusErrorController;	//	#12
	private static DisStatusErrorController 	disStatusErrorController;	//	#13
	private static RinStatusErrorController 	rinStatusErrorController;	//	#14
	private static MatStatusWarningController 	matStatusWarningController;	//	#15
	
	private Stage stage;
    private HashMap<SceneID, Scene> scenes = new HashMap<>();
	
    // Costruttore
	private SceneManager(Stage stage) {
		SystemLog.println("SceneManager : entered SceneManager()");
		
		this.stage = stage;
		
		SceneFactory factory = new SceneFactory();
		for (SceneID sceneID : SceneID.values()) {
		    addScene(factory.createScene(sceneID), sceneID);
		}
	}
	
	// Per la creazione dell'istanza
	public static SceneManager getInstance(Stage stage) {
		SystemLog.println("SceneManager : entered getInstance()");
		
		if (stage == null) {
			throw new IllegalArgumentException("stage is null");
		}
		
		if (instance == null) {
			instance = new SceneManager(stage);
			makeSceneControllers();
		}
		return instance;
	}
	
	private static void makeSceneControllers() {
		SystemLog.println("SceneManager : entered makeSceneControllers()");
		
		// Controllor scena primaria
    	dashboardController 		= new DashboardController		(DashboardScene.getInstance());
    	
    	// Controllor scene secondarie 
    	registrationController 		= new RegistrationController	(RegistrationScene.getInstance());
    	renewalController 			= new RenewalController			(RenewalScene.getInstance());
    	unsubscribeController 		= new UnsubscribeController		(UnsubscribeScene.getInstance());
		calculateFeeController 		= new CalculateFeeController	(CalculateFeeScene.getInstance());
    	printListsController 		= new PrintListsController		(PrintListsScene.getInstance());
    	
    	// Controllor scene intermedie
    	selectActivityController	= new SelectActivityController	(SelectActivityScene.getInstance()); 
    	showListController			= new ShowListController		(ShowListScene.getInstance()); 

    	// Controller scene terziarie
    	regStatusOkController 		= new RegStatusOkController		((StatusSceneOK)instance.getScene(SceneID.STATUS_REG_OK));
    	disStatusOkController 		= new DisStatusOkController		((StatusSceneOK)instance.getScene(SceneID.STATUS_DIS_OK));
    	acqStatusOkController 		= new AcqStatusOkController		((StatusSceneOK)instance.getScene(SceneID.STATUS_ACQ_OK));
    	regStatusErrorController 	= new RegStatusErrorController	((StatusSceneError)instance.getScene(SceneID.STATUS_REG_ERROR));
    	disStatusErrorController 	= new DisStatusErrorController	((StatusSceneError)instance.getScene(SceneID.STATUS_DIS_ERROR));
    	rinStatusErrorController 	= new RinStatusErrorController	((StatusSceneError)instance.getScene(SceneID.STATUS_RIN_ERROR));
    	matStatusWarningController 	= new MatStatusWarningController((StatusSceneWarning)instance.getScene(SceneID.STATUS_MAT_WARNING));
		
	}

	// Per il prelievo dell' istanza
	public static SceneManager getInstance() {
		SystemLog.println("SceneManager : entered getInstance()");
		
		if (instance == null) {
			throw new IllegalArgumentException("SceneManager's instance is null, try getInstance(Stage)");
		}
		return instance;
	}
	
	// Agginge una Scene alla map interna
	public void addScene(Scene scene, SceneID id) {
		SystemLog.println("SceneManager : entered addScene()");
		
        scenes.put(id, scene);
    }
	
	// Restituisce una scena dalla mappa interna
	public Scene getScene(SceneID id) {
		SystemLog.println("SceneManager : entered getScene()");
		
		return scenes.get(id);
	}
	
	// Mostra una Scene desiderata a schermo
	public void switchTo(SceneID id) {
		SystemLog.println("SceneManager : entered switchTo()");
		
        Scene scene = scenes.get(id);
        
        if (scene != null) {
            stage.setScene(scene);
        } else {
        	throw new IllegalArgumentException("The scene with id=" + id.getId() + " wasn't fuond.");
        }
    }

	public DashboardController getDashboardController() {
		SystemLog.println("SceneManager : entered getDashboardController()");
		
		return dashboardController;
	}

	public RegistrationController getRegistrationController() {
		SystemLog.println("SceneManager : entered getRegistrationController()");
		
		return registrationController;
	}

	public RenewalController getRenewalController() {
		SystemLog.println("SceneManager : entered getRenewalController()");
		
		return renewalController;
	}

	public UnsubscribeController getUnsubscribeController() {
		SystemLog.println("SceneManager : entered getUnsubscribeController()");
		
		return unsubscribeController;
	}

	public CalculateFeeController getCalculateFeeController() {
		SystemLog.println("SceneManager : entered getCalculateFeeController()");
		
		return calculateFeeController;
	}

	public PrintListsController getPrintListsController() {
		SystemLog.println("SceneManager : entered getPrintListsController()");
		
		return printListsController;
	}

	public SelectActivityController getSelectActivityController() {
		SystemLog.println("SceneManager : entered getSelectActivityController()");
		
		return selectActivityController;
	}

	public ShowListController getShowListController() {
		SystemLog.println("SceneManager : entered getShowListController()");
		
		return showListController;
	}

	public RegStatusOkController getRegStatusOkController() {
		SystemLog.println("SceneManager : entered getRegStatusOkController()");
		
		return regStatusOkController;
	}

	public DisStatusOkController getDisStatusOkController() {
		SystemLog.println("SceneManager : entered getDisStatusOkController()");
		
		return disStatusOkController;
	}

	public AcqStatusOkController getAcqStatusOkController() {
		SystemLog.println("SceneManager : entered getAcqStatusOkController()");
		
		return acqStatusOkController;
	}

	public RegStatusErrorController getRegStatusErrorController() {
		SystemLog.println("SceneManager : entered getRegStatusErrorController()");
		
		return regStatusErrorController;
	}

	public DisStatusErrorController getDisStatusErrorController() {
		SystemLog.println("SceneManager : entered getDisStatusErrorController()");
		
		return disStatusErrorController;
	}

	public RinStatusErrorController getRinStatusErrorController() {
		SystemLog.println("SceneManager : entered getRinStatusErrorController()");
		
		return rinStatusErrorController;
	}

	public MatStatusWarningController getMatStatusWarningController() {
		SystemLog.println("SceneManager : entered getMatStatusWarningController()");
		
		return matStatusWarningController;
	}

	public Stage getStage() {
		SystemLog.println("SceneManager : entered getStage()");
		
		return stage;
	}

	public HashMap<SceneID, Scene> getScenes() {
		SystemLog.println("SceneManager : entered getScenes()");
		
		return scenes;
	}
}
