package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public abstract class AttivitaSportiva {
	
	private ActivityID id;
	private String nome;
	private Double prezzo;
	
	public AttivitaSportiva() {
		SystemLog.println("AttivitaSportiva : entered AttivitaSportiva()");
		
	}
	
	public AttivitaSportiva(ActivityID id, String nome) {
		SystemLog.println("AttivitaSportiva : entered AttivitaSportiva()");
		
		this.id = id;
		this.nome = nome;
	}
	
	public AttivitaSportiva(ActivityID id, String nome, Double prezzo) {
		SystemLog.println("AttivitaSportiva : entered AttivitaSportiva()");
		
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public String getNome() {
		SystemLog.println("AttivitaSportiva : entered getNome()");
		
		return nome;
	}
	
	public ActivityID getId() {
		SystemLog.println("AttivitaSportiva : entered getId()");
		
		return id;
	}

	public Double getPrezzo() {
		SystemLog.println("AttivitaSportiva : entered getPrezzo()");
		
		return prezzo;
	}

	protected void setId(ActivityID id) {
		SystemLog.println("AttivitaSportiva : entered setId()");
		
		this.id = id;
	}

	protected void setNome(String nome) {
		SystemLog.println("AttivitaSportiva : entered setNome()");
		
		this.nome = nome;
	}

	public void setPrezzo(Double prezzo) {
		SystemLog.println("AttivitaSportiva : entered setPrezzo()");
		
		this.prezzo = prezzo;
	}
	
	
}
