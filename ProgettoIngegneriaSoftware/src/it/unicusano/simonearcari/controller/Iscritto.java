package it.unicusano.simonearcari.controller;

import it.unicusano.simonearcari.SystemLog;

public class Iscritto {
    private Integer matricola;
    private String nome;
    private String cognome;

    public Iscritto(Integer matricola, String nome, String cognome) {
		SystemLog.println("Iscritto : entered Iscritto()");
		
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Integer getMatricola() {
		SystemLog.println("Iscritto : entered getMatricola()");
		
        return matricola;
    }

    public void setMatricola(Integer matricola) {
		SystemLog.println("Iscritto : entered setMatricola()");
		
        this.matricola = matricola;
    }

    public String getNome() {
		SystemLog.println("Iscritto : entered getNome()");
		
        return nome;
    }

    public void setNome(String nome) {
		SystemLog.println("Iscritto : entered setNome()");
		
        this.nome = nome;
    }

    public String getCognome() {
		SystemLog.println("Iscritto : entered getCognome()");
		
        return cognome;
    }

    public void setCognome(String cognome) {
		SystemLog.println("Iscritto : entered setCognome()");
		
        this.cognome = cognome;
    }
}
