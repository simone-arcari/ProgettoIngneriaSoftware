package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.view.BaseScene;
import it.unicusano.simonearcari.view.CalculateFeeScene;
import it.unicusano.simonearcari.view.DashboardScene;
import it.unicusano.simonearcari.view.RegistrationScene;
import it.unicusano.simonearcari.view.RenewalScene;
import it.unicusano.simonearcari.view.SelectActivityScene;
import it.unicusano.simonearcari.view.ShowListScene;
import it.unicusano.simonearcari.view.PrintListsScene;
import it.unicusano.simonearcari.view.StatusSceneError;
import it.unicusano.simonearcari.view.StatusSceneOK;
import it.unicusano.simonearcari.view.StatusSceneWarning;
import it.unicusano.simonearcari.view.UnsubscribeScene;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SceneFactory {

    private final Map<SceneID, Supplier<Scene>> sceneSuppliers = new HashMap<>();

    public SceneFactory() {
		SystemLog.println("SceneFactory : entered SceneFactory()");
		
    	// Scena primaria
        sceneSuppliers.put(SceneID.DASHBOARD, DashboardScene::getInstance);
        
        // Scene secondarie
        sceneSuppliers.put(SceneID.REGISTRATION, RegistrationScene::getInstance);
        sceneSuppliers.put(SceneID.RENEWAL, RenewalScene::getInstance);
        sceneSuppliers.put(SceneID.UNSUBSCRIBE, UnsubscribeScene::getInstance);
        sceneSuppliers.put(SceneID.CALCULATE_FEE, CalculateFeeScene::getInstance);
        sceneSuppliers.put(SceneID.PRINT_LISTS, PrintListsScene::getInstance);
        
        // Scene intermedie
        sceneSuppliers.put(SceneID.SELECT_ACTIVITY, SelectActivityScene::getInstance);
        sceneSuppliers.put(SceneID.SHOW_LIST, ShowListScene::getInstance);
        
        // Scene terziarie
        sceneSuppliers.put(SceneID.STATUS_REG_OK, () -> new StatusSceneOK(new VBox()));
        sceneSuppliers.put(SceneID.STATUS_DIS_OK, () -> new StatusSceneOK(new VBox()));
        sceneSuppliers.put(SceneID.STATUS_ACQ_OK, () -> new StatusSceneOK(new VBox()));
        sceneSuppliers.put(SceneID.STATUS_REG_ERROR, () -> new StatusSceneError(new VBox()));
        sceneSuppliers.put(SceneID.STATUS_DIS_ERROR, () -> new StatusSceneError(new VBox()));
        sceneSuppliers.put(SceneID.STATUS_RIN_ERROR, () -> new StatusSceneError(new VBox()));
        sceneSuppliers.put(SceneID.STATUS_MAT_WARNING, () -> new StatusSceneWarning(new VBox()));
    }

    public Scene createScene(SceneID sceneID) {
		SystemLog.println("SceneFactory : entered createScene()");
		
        Supplier<Scene> sceneSupplier = sceneSuppliers.get(sceneID);
        
        if (sceneSupplier == null) {
        	throw new IllegalArgumentException("ID scena non valido: " + sceneID);
        }
        
        Scene scene = sceneSupplier.get();
        customizeScene(scene, sceneID);
        
        return scene;
    }
    
    private Scene customizeScene(Scene scene, SceneID id) {
		SystemLog.println("SceneFactory : entered customizeScene()");
    	
    	BaseScene baseScene = (BaseScene)scene;
    	
    	switch(id) {
    	case SceneID.STATUS_REG_OK:    		
    		baseScene.setTitleText("Registrazione Effettuata");
    		baseScene.setBtn1Text("Seleziona Attività Sportive");
    		baseScene.setBtn2Text("Fine");
    		
    		break;
    		
    	case SceneID.STATUS_DIS_OK:    		
    		baseScene.setTitleText("Disiscrizione Effettuata");
    		baseScene.setBtn2Visible(false);
    		baseScene.setBtn1Text("Fine");
    		
    		break;
    		
    	case SceneID.STATUS_ACQ_OK:    		
    		baseScene.setTitleText("Acquisto Effettuato");
    		baseScene.setBtn2Visible(false);
    		baseScene.setBtn1Text("Fine");
    		
    		break;
    		
    	case SceneID.STATUS_REG_ERROR:    		
    		baseScene.setTitleText("Errore Registrazione");
    		baseScene.setBtn1Text("Prova Rinnovo Abbonamento");
    		baseScene.setBtn2Text("Fine");
    		
    		break;
    		
    	case SceneID.STATUS_DIS_ERROR:    		
    		baseScene.setTitleText("Errore Disiscrizione");
    		baseScene.setBtn2Visible(false);
    		baseScene.setBtn1Text("Fine");
    		
    		break;
    		
    	case SceneID.STATUS_RIN_ERROR:    		
    		baseScene.setTitleText("Errore Rinnovo");
    		baseScene.setBtn2Visible(false);
    		baseScene.setBtn1Text("Fine");
    		
    		break;
    		
    	case SceneID.STATUS_MAT_WARNING:    		
    		baseScene.setTitleText("Matricola Inesistente");
    		baseScene.setBtn2Visible(false);;
    		baseScene.setBtn1Text("Fine");
    		
    		break;
    		
    		
    	default:
    		break;
    	}
    	
    	return scene;
    }
}

