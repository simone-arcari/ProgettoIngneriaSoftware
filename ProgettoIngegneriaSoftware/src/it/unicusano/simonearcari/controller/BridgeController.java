package it.unicusano.simonearcari.controller;

import java.util.List;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.model.DBCustomer;
import it.unicusano.simonearcari.model.SystemManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BridgeController {
	
	private static BridgeController instance;
	
	private SystemManager systemManager;

	private BridgeController(SystemManager systemManager) {
		SystemLog.println("BridgeController : entered BridgeController()");
		
		this.systemManager = systemManager;
	}
	
	public static BridgeController getInstance(SystemManager systemManager) {
		SystemLog.println("BridgeController : entered getInstance()");
		
		if (instance == null) {
			if (systemManager == null) {
				SystemLog.println("La prima volta in assoluto che si istanzia BridgeController bisogna passare un oggetto SystemManager valido");
				return null;
			}
			else {
				instance = new BridgeController(systemManager);
			}
		}
		
		return instance;
	}

	public boolean registerCustomer(String nome, String cognome, Integer matricola) {
		SystemLog.println("BridgeController : entered registerCustomer()");
		
		return systemManager.registerCustomer(nome, cognome, matricola);
	}

	public boolean findMatricola(Integer matricola) {
		SystemLog.println("BridgeController : entered findMatricola()");
		
		return systemManager.findMatricola(matricola);
	}

	public Double calculatePrezzo(boolean nuoto, boolean atletica, boolean bodybuilding) {
		SystemLog.println("BridgeController : entered calculatePrezzo()");
		
		return systemManager.calculatePrezzo(nuoto, atletica, bodybuilding);
	}

	public void setSubscription(Integer matricola, boolean nuoto, boolean atletica, boolean bodybuilding) {
		SystemLog.println("BridgeController : entered setSubscription()");
		
		systemManager.setSubscription(matricola, nuoto, atletica, bodybuilding);
	}

	public Double getPrezzo(Integer matricola) {
		SystemLog.println("BridgeController : entered getPrezzo()");
		
		return systemManager.getPrezzo(matricola);
	}

	public ObservableList<Iscritto> getIscrittiGenerale() {
		SystemLog.println("BridgeController : entered getIscrittiGenerale()");
		
		List<DBCustomer> customers = systemManager.getIscrittiGenerale();
		ObservableList<Iscritto> iscritti = FXCollections.observableArrayList();

		for (DBCustomer customer : customers) {
			
			Integer matricola = customer.matricola;
			String nome = customer.nome;
			String cognome = customer.cognome;
			
			Iscritto iscritto = new Iscritto(matricola, nome, cognome);
			iscritti.add(iscritto);
		}
		
		return iscritti;
	}

	public ObservableList<Iscritto> getIscrittiNuoto() {
		SystemLog.println("BridgeController : entered getIscrittiNuoto()");
		
		List<DBCustomer> customers = systemManager.getIscrittiNuoto();
		ObservableList<Iscritto> iscritti = FXCollections.observableArrayList();

		for (DBCustomer customer : customers) {
			
			Integer matricola = customer.matricola;
			String nome = customer.nome;
			String cognome = customer.cognome;
			
			Iscritto iscritto = new Iscritto(matricola, nome, cognome);
			iscritti.add(iscritto);
		}
		
		return iscritti;
	}

	public ObservableList<Iscritto> getIscrittiAtletica() {
		SystemLog.println("BridgeController : entered getIscrittiAtletica()");
		
		List<DBCustomer> customers = systemManager.getIscrittiAtletica();
		ObservableList<Iscritto> iscritti = FXCollections.observableArrayList();

		for (DBCustomer customer : customers) {
			
			Integer matricola = customer.matricola;
			String nome = customer.nome;
			String cognome = customer.cognome;
			
			Iscritto iscritto = new Iscritto(matricola, nome, cognome);
			iscritti.add(iscritto);
		}
		
		return iscritti;
	}

	public ObservableList<Iscritto> getIscrittiBodybuilding() {
		SystemLog.println("BridgeController : entered getIscrittiBodybuilding()");
		
		List<DBCustomer> customers = systemManager.getIscrittiBodybuilding();
		ObservableList<Iscritto> iscritti = FXCollections.observableArrayList();

		for (DBCustomer customer : customers) {
			
			Integer matricola = customer.matricola;
			String nome = customer.nome;
			String cognome = customer.cognome;
			
			Iscritto iscritto = new Iscritto(matricola, nome, cognome);
			iscritti.add(iscritto);
		}
		
		return iscritti;
	}

	public ObservableList<Iscritto> getAllRegisterdCustomers() {
		SystemLog.println("BridgeController : entered getAllRegisterdCustomers()");
		
		List<DBCustomer> customers = systemManager.getAllRegisterdCustomers();
		ObservableList<Iscritto> clienti = FXCollections.observableArrayList();

		for (DBCustomer customer : customers) {
			
			Integer matricola = customer.matricola;
			String nome = customer.nome;
			String cognome = customer.cognome;
			
			Iscritto iscritto = new Iscritto(matricola, nome, cognome);
			clienti.add(iscritto);
		}
		
		return clienti;
	}
}
