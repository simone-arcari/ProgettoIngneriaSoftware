package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class Customer {
	private final Integer matricola;
	private final String nome;
	private final String cognome;
	
	private Subscription subscription;
	
	public Customer(Integer matricola, String nome, String cognome) {		
		SystemLog.println("Customer : entered Customer()");
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Integer getMatricola() {
		SystemLog.println("Customer : entered getMatricola()");
		
		return matricola;
	}

	public String getNome() {
		SystemLog.println("Customer : entered getNome()");
		
		return nome;
	}

	public String getCognome() {
		SystemLog.println("Customer : entered getCognome()");
		
		return cognome;
	}
	
	public void setSubscription(boolean nuoto, boolean atletica, boolean bodybuilding) {
		SystemLog.println("Customer : entered setSubscription()");
        
		if (subscription == null && (nuoto || atletica || bodybuilding)) {
			// Creiamo un abbonamento solo se non esiste e se ci sono attività selezionate
	        subscription = new Subscription(nuoto, atletica, bodybuilding);
	        subscription.setOwner(this);
	    } 
		else {
	        if (!nuoto && !atletica && !bodybuilding) {
	            // Rimuoviamo la sottoscrizione se tutte le attività sono false
	            subscription = null;
	        } else {
	            // Aggiorniamo la sottoscrizione esistente
	            subscription.setNuoto(nuoto);
	            subscription.setAtletica(atletica);
	            subscription.setBodybuilding(bodybuilding);
	        }
	    }
	}

	public boolean isSubscribed() {
		SystemLog.println("Customer : entered isSubscribed()");
		
		if (subscription != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public Subscription getSubscription() {
		SystemLog.println("Customer : entered getSubscription()");
		
		return subscription;
	}
}
