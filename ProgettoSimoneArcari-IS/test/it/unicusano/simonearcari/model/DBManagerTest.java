package it.unicusano.simonearcari.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DBManagerTest {
    
    private static DBManager dbManager;

    @BeforeAll
    public static void setup() {
        // Inizializza il database e il DBManager prima di eseguire i test
        dbManager = DBManager.getInstance();
    }

    @AfterAll
    public static void tearDown() {
        // Chiudi la connessione al database dopo aver eseguito i test
        dbManager.close();
    }

    @Test
    public void testInsertCustomer() {
        dbManager.insertCustomer(10, "Mario", "Rossi");
        
        // Verifica che il cliente sia stato inserito correttamente
        List<DBCustomer> customers = dbManager.getAllCustomers();
        assertNotNull(customers);

        boolean res = true;
        
        for (DBCustomer customer : customers) {
        	if (customer.matricola == 10 && customer.nome == "Mario" && customer.cognome == "Rossi") {
        		res = true;
        		break;
        	}
        }
        assertTrue(res, "Il cliente Mario Rossi non è stato trovato");
    }

    @Test
    public void testInsertActivity() {
        dbManager.insertActivity(700, "Yoga", 30.0);

        // Verifica che l'attività sia stata inserita correttamente
        List<DBActivity> activities = dbManager.getAllActivity();
        assertNotNull(activities);
        
        boolean res = true;
        
        for (DBActivity activity : activities) {        	
        	if (activity.id == 700 && activity.nome == "Yoga" && activity.prezzo == 30.0) {
        		res = true;
        		break;
        	}
        }

        assertTrue(res, "L'attivita inserita non e' stata trovata");
    }

    @Test
    public void testGetAllCustomers() {
        dbManager.insertCustomer(2, "Luigi", "Bianchi");
        List<DBCustomer> customers = dbManager.getAllCustomers();
        
        assertNotNull(customers);
        assertFalse(customers.isEmpty(), "La lista dei clienti non dovrebbe essere vuota");
    }

    @Test
    public void testGetAllActivity() {
        dbManager.insertActivity(2, "Pilates", 45.00);
        List<DBActivity> activities = dbManager.getAllActivity();
        
        assertNotNull(activities);
        assertFalse(activities.isEmpty(), "La lista delle attività non dovrebbe essere vuota");
    }

    @Test
    public void testInsertSubscription() {
        dbManager.insertCustomer(3, "Giorgio", "Verdi");
        dbManager.insertActivity(3, "Spinning", 50.00);
        
        dbManager.insertSubscription(3, 3);

        // Verifica che l'abbonamento sia stato inserito correttamente
        List<String> activities = dbManager.getSubscriptionByCustomer(3);
        assertNotNull(activities);
        
        boolean res = true;
        
        for (String activity : activities) {        	
        	if (activity== "Spinning") {
        		res = true;
        		break;
        	}
        }
        assertTrue(res, "L'attività Spinning non è stata trovata per il cliente");
    }

    @Test
    public void testGetSubscriptionByCustomer() {
        dbManager.insertCustomer(4, "Giulia", "Neri");
        dbManager.insertActivity(4, "Zumba", 40.00);
        dbManager.insertSubscription(4, 4);

        List<String> activities = dbManager.getSubscriptionByCustomer(4);
        assertNotNull(activities);
        assertFalse(activities.isEmpty(), "La lista delle attività per il cliente non dovrebbe essere vuota");
        assertTrue(activities.contains("Zumba"), "L'attività Zumba non è stata trovata per il cliente");
    }

    @Test
    public void testGetCustomersByActivity() {
        dbManager.insertCustomer(5, "Alessia", "Blu");
        dbManager.insertActivity(5, "Boxe", 60.00);
        dbManager.insertSubscription(5, 5);

        List<DBCustomer> customers = dbManager.getCustomersByActivity(5);
        assertNotNull(customers);

        boolean res = true;
        
        for (DBCustomer customer : customers) {
        	if (customer.matricola == 5 && customer.nome == "Alessia" && customer.cognome == "Blu") {
        		res = true;
        		break;
        	}
        }
        assertTrue(res, "Il cliente Alessia Blu non è stato trovato");
    }

    @Test
    public void testDoesMatricolaExist() {
        dbManager.insertCustomer(6, "Franco", "Gialli");
        boolean exists = dbManager.doesMatricolaExist(6);
        assertTrue(exists, "La matricola 6 non è stata trovata");
        
        boolean notExists = dbManager.doesMatricolaExist(999);
        assertFalse(notExists, "La matricola 999 non dovrebbe esistere");
    }
}
