package it.unicusano.simonearcari.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unicusano.simonearcari.SystemLog;
import it.unicusano.simonearcari.controller.BridgeController;

public class SystemManager {

	private static SystemManager instance;
	
	private DBManager dbManager;
	private List<Customer> customers = new ArrayList<>();
	private Map<Integer, Customer> customersMap = new HashMap<>();
	
	private Nuoto attivitaNuoto;
	private Atletica attivitaAtletica;
	private Bodybuilding attivitaBodybuilding;
	
	private BridgeController bridgeController;
	

	private SystemManager() {
		SystemLog.println("SystemManager : entered SystemManager()");
		
		dbManager = DBManager.getInstance();
		bridgeController = BridgeController.getInstance(this);
		
		//Carica tutti i dati dal db
		refreshCustomers();
		refreshSportActivity();
		refreshSubscription();
	}
	
	public static SystemManager getInstance() {
		SystemLog.println("SystemManager : entered getInstance()");
		
		if (instance == null) {
			instance = new SystemManager();
		}
		return instance;
	}
	
	private void refreshCustomers() {
		SystemLog.println("SystemManager : entered refreshCustomers()");
		
		List<DBCustomer> dbCustomers;
		dbCustomers = dbManager.getAllCustomers();
		
		if (customers != null) {
			customers.clear();			
		}
		
		for (DBCustomer dbCustomer : dbCustomers) {
			Integer matricola = dbCustomer.matricola;
			String nome = dbCustomer.nome;
			String cognome = dbCustomer.cognome;
			
			Customer customer = new Customer(matricola, nome, cognome);
			
			customers.add(customer);
			customersMap.put(matricola, customer);
		}
	}
	
	private void refreshSubscription() {
		SystemLog.println("SystemManager : entered refreshSubscription()");
		
		if (customers == null) {
			return;
		}
		
		for (Customer customer : customers) {
			Integer matricola = customer.getMatricola();
			List<Integer> ids = dbManager.getSubscriptionIdByCustomer(matricola);
			
			boolean nuoto = false;
			boolean atletica = false;
			boolean bodybuilding = false;
			
			if (ids != null) {
				for (Integer id : ids) {
					if (id == ActivityID.NUOTO.getId()) {
						nuoto = true;
					}
					else if (id == ActivityID.ATLETICA.getId()) {
						atletica = true;
					} 
					else if (id == ActivityID.BODYBUILDING.getId()) {
						bodybuilding = true;
					}
				}
				customer.setSubscription(nuoto, atletica, bodybuilding);
			}
		}	
	}
	
	private void refreshSportActivity() {
		SystemLog.println("SystemManager : entered refreshSportActivity()");
		
		List<DBActivity> dbActivities;
		dbActivities = dbManager.getAllActivity();
		
		for (DBActivity dbActivity : dbActivities) {
			Integer id = dbActivity.id;
			Double prezzo = dbActivity.prezzo;
			
			if (id == ActivityID.NUOTO.getId()) {
				SystemLog.println("SystemManager : refreshSportActivity : get Nuoto From db");
				attivitaNuoto = Nuoto.getInstance();
				attivitaNuoto.setPrezzo(prezzo);
				
			}
			else if (id == ActivityID.ATLETICA.getId()) {
				SystemLog.println("SystemManager : refreshSportActivity : get Atletica from db");
				attivitaAtletica = Atletica.getInstance();
				attivitaAtletica.setPrezzo(prezzo);
				
			}
			else if (id == ActivityID.BODYBUILDING.getId()) {
				SystemLog.println("SystemManager : refreshSportActivity : get Bodibuilding from db");
				attivitaBodybuilding = Bodybuilding.getInstance();
				attivitaBodybuilding.setPrezzo(prezzo);
			}
		}
	}
	
	private void addCustomer(Integer matricola, String nome, String cognome) {
		SystemLog.println("SystemManager : entered addCustomer()");
		
		Customer customer = new Customer(matricola, nome, cognome);
		
		customers.add(customer);
		customersMap.put(matricola, customer);
	}

	public boolean registerCustomer(String nome, String cognome, Integer matricola) {
		SystemLog.println("SystemManager : entered registerCustomer()");
		
		boolean rslt;
		
		rslt = dbManager.insertCustomer(matricola, nome, cognome);
		
		if (rslt) {
			addCustomer(matricola, cognome, cognome);
		}
		
		return rslt;
	}

	public boolean findMatricola(Integer matricola) {
		SystemLog.println("SystemManager : entered findMatricola()");
		
		return dbManager.doesMatricolaExist(matricola);
	}

	public Double calculatePrezzo(boolean nuoto, boolean atletica, boolean bodybuilding) {
		SystemLog.println("SystemManager : entered calculatePrezzo()");
		
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
		
		BigDecimal bd = new BigDecimal(prezzo).setScale(2, RoundingMode.HALF_UP);
		Double roundedPrezzo = bd.doubleValue();
		
		return roundedPrezzo;
	}
	

	public void setSubscription(Integer matricola, boolean nuoto, boolean atletica, boolean bodybuilding) {
		SystemLog.println("SystemManager : entered setSubscription()");
		
		Customer customer = customersMap.get(matricola);
		customer.setSubscription(nuoto, atletica, bodybuilding);
		
		// Gestione abbonameto Nuoto
		if (nuoto) {
			dbManager.insertSubscription(matricola, ActivityID.NUOTO.getId());
		}
		else {
			dbManager.deleteSubscription(matricola, ActivityID.NUOTO.getId());
		}
		
		// Gestione abbonameto Atletica
		if (atletica) {
			dbManager.insertSubscription(matricola, ActivityID.ATLETICA.getId());
		}
		else {
			dbManager.deleteSubscription(matricola, ActivityID.ATLETICA.getId());
		}
		
		// Gestione abbonameto Bodybuilding
		if (bodybuilding) {
			dbManager.insertSubscription(matricola, ActivityID.BODYBUILDING.getId());
		}
		else {
			dbManager.deleteSubscription(matricola, ActivityID.BODYBUILDING.getId());
		}
		
		
	}

	public Double getPrezzo(Integer matricola) {
		SystemLog.println("SystemManager : entered getPrezzo()");
		
		Double prezzo = customersMap.get(matricola).getSubscription().getPrezzo();
		
		BigDecimal bd = new BigDecimal(prezzo).setScale(2, RoundingMode.HALF_UP);
		Double roundedPrezzo = bd.doubleValue();
		
		return roundedPrezzo;
	}

	public List<DBCustomer> getIscrittiGenerale() {
		SystemLog.println("SystemManager : entered getIscrittiGenerale()");
		
		return dbManager.getAllCustomersWithSubscription();
	}

	public List<DBCustomer> getIscrittiNuoto() {
		SystemLog.println("SystemManager : entered getIscrittiNuoto()");
		
		return dbManager.getCustomersByActivity(ActivityID.NUOTO.getId());
	}
	
	public List<DBCustomer> getIscrittiAtletica() {
		SystemLog.println("SystemManager : entered getIscrittiAtletica()");
		
		return dbManager.getCustomersByActivity(ActivityID.ATLETICA.getId());
	}
	
	public List<DBCustomer> getIscrittiBodybuilding() {
		SystemLog.println("SystemManager : entered getIscrittiBodybuilding()");
		
		return dbManager.getCustomersByActivity(ActivityID.BODYBUILDING.getId());
	}

	public List<DBCustomer> getAllRegisterdCustomers() {
		SystemLog.println("SystemManager : entered getAllRegisterdCustomers()");
		
		return dbManager.getAllCustomers();
	}

	public BridgeController getBridgeController() {
		SystemLog.println("SystemManager : entered getBridgeController()");
		
		return bridgeController;
	}
	
	public void closeDataBase() {
		SystemLog.println("SystemManager : entered closeDataBase()");
		
		dbManager.close();
	}
}
