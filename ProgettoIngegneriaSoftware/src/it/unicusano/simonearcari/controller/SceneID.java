package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;

public enum SceneID {
	// Scena primaria
    DASHBOARD(1),
    
    // Scene secondarie
    REGISTRATION(2),
    RENEWAL(3),
    UNSUBSCRIBE(4),
    CALCULATE_FEE(5),
    PRINT_LISTS(6),
    
    // Scene intermedie
    SELECT_ACTIVITY(7),
    SHOW_LIST(8),
    
    // Scene terziarie
	STATUS_REG_OK(9),
	STATUS_DIS_OK(10),
	STATUS_ACQ_OK(11),
	STATUS_REG_ERROR(12),
	STATUS_DIS_ERROR(13),
	STATUS_RIN_ERROR(14),
	STATUS_MAT_WARNING(15);
    
    private final int id;

    SceneID(int id) {
		SystemLog.println("SceneID : entered SceneID()");
		
        this.id = id;
    }

    public int getId() {
		SystemLog.println("SceneID : entered getId()");
		
        return id;
    }
}
