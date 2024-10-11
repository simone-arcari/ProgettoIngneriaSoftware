package it.unicusano.simonearcari.model;

import it.unicusano.simonearcari.SystemLog;

public class DBActivity {
	public Integer id;
	public String nome;
	public Double prezzo;
	
	public DBActivity(Integer id, String nome, Double prezzo) {
		SystemLog.println("DBActivity : entered DBActivity()");
		
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
	}
}
