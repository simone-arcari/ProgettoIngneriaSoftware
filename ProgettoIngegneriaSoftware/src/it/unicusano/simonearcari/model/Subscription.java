package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class Subscription {
	
	private Customer owner;
	
	// Indicano quali attivita fanno effettivamente parte dell'abbonamento
	private boolean nuoto;
	private boolean atletica;
	private boolean bodybuilding;
	
	// Istanze Singleton delle attivita sportive
	private Nuoto attivitaNuoto; 
	private Atletica attivitaAtletica;
	private Bodybuilding attivitaBodybuilding; 
	
	public Subscription(boolean nuoto, boolean atletica, boolean bodybuilding) {
		SystemLog.println("Subscription : entered Subscription()");
		
		this.nuoto = nuoto;
		this.atletica = atletica;
		this.bodybuilding = bodybuilding;
		
		attivitaNuoto = Nuoto.getInstance(); 
		attivitaAtletica = Atletica.getInstance();
		attivitaBodybuilding = Bodybuilding.getInstance(); 
	}

	public Customer getOwner() {
		SystemLog.println("Subscription : entered getOwner()");
		
		return owner;
	}

	public void setOwner(Customer owner) {
		SystemLog.println("Subscription : entered setOwner()");
		
		this.owner = owner;
	}

	public boolean isNuoto() {
		SystemLog.println("Subscription : entered isNuoto()");
		
		return nuoto;
	}

	public void setNuoto(boolean nuoto) {
		SystemLog.println("Subscription : entered setNuoto()");
		
		this.nuoto = nuoto;
	}

	public boolean isAtletica() {
		SystemLog.println("Subscription : entered isAtletica()");
		
		return atletica;
	}

	public void setAtletica(boolean atletica) {
		SystemLog.println("Subscription : entered setAtletica()");
		
		this.atletica = atletica;		
	}

	public boolean isBodybuilding() {
		SystemLog.println("Subscription : entered isBodybuilding()");
		
		return bodybuilding;
	}

	public void setBodybuilding(boolean bodybuilding) {
		SystemLog.println("Subscription : entered setBodybuilding()");
		
		this.bodybuilding = bodybuilding;
	}
	
	public Double getPrezzo() {
		SystemLog.println("Subscription : entered getPrezzo()");
		
		Double prezzo = 0.0;
		
		if (nuoto) {
			prezzo += attivitaNuoto.getPrezzo();
		}
		
		if (atletica) {
			prezzo += attivitaAtletica.getPrezzo();
		}
		
		if (bodybuilding) {
			prezzo += attivitaBodybuilding.getPrezzo();
		}
		
		return prezzo;
	}
}
