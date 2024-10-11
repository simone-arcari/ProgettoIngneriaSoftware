package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public enum ActivityID {
	NUOTO(1),
	ATLETICA(2),
	BODYBUILDING(3);
	
    private final int id;

    ActivityID(int id) {
    	SystemLog.println("ActivityID : entered ActivityID()");
    	
        this.id = id;
    }

    public int getId() {
    	SystemLog.println("ActivityID : entered getId()");
    	
        return id;
    }
}
