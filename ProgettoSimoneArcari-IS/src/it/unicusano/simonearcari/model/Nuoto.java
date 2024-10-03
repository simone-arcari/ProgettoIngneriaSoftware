package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class Nuoto extends AttivitaSportiva {
	
	private static Nuoto instance;

//	public Nuoto(ActivityID id, String nome) {
//		super(id, nome);
//	}
//	
//	public Nuoto(ActivityID id, String nome, Double prezzo) {
//		super(id, nome, prezzo);
//	}
	
	private Nuoto() {
		super();
		SystemLog.println("Nuoto : entered Nuoto()");
		
		
		setId(ActivityID.NUOTO);
		setNome("Atletica");
	}
	
	public static Nuoto getInstance() {
		SystemLog.println("Nuoto : entered getInstance()");
		
		if (instance == null) {
			instance = new Nuoto();
		}
		
		return instance;
	}
}
