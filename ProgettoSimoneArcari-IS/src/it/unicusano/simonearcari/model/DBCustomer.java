package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class DBCustomer {
	public Integer matricola;
	public String nome;
	public String cognome;
	
	public DBCustomer(Integer matricola, String nome, String cognome) {
		SystemLog.println("DBCustomer : entered DBCustomer()");
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
}
