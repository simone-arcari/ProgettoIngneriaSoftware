package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class Atletica extends AttivitaSportiva {
	
	private static Atletica instance;
	
	private Atletica() {
		super();
		SystemLog.println("Atletica : entered Atletica()");
		
		setId(ActivityID.ATLETICA);
		setNome("Atletica");
	}
	
	public static Atletica getInstance() {
		SystemLog.println("Atletica : entered getInstance()");
		
		if (instance == null) {
			instance = new Atletica();
		}
		
		return instance;
	}
}