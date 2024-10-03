package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class Bodybuilding extends AttivitaSportiva {
	
	private static Bodybuilding instance;

//	public Bodybuilding(ActivityID id, String nome) {
//		super(id, nome);
//	}
//	
//	public Bodybuilding(ActivityID id, String nome, Double prezzo) {
//		super(id, nome, prezzo);
//	}
	
	private Bodybuilding() {
		SystemLog.println("Bodybuilding : entered Bodybuilding()");
		
		setId(ActivityID.BODYBUILDING);
		setNome("Bodybuilding");
	}
	
	public static Bodybuilding getInstance() {
		SystemLog.println("Bodybuilding : entered Bodybuilding()");
		
		if (instance == null) {
			instance = new Bodybuilding();
		}
		return instance;
	}
}