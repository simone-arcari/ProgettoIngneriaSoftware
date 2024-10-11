package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class SystemManagerTest {

    private SystemManager systemManager;

    @BeforeEach
    public void setUp() {
        // Inizializza l'istanza di SystemManager prima di ogni test
        systemManager = SystemManager.getInstance();
    }

    @Test
    public void testGetInstance() {
        SystemManager instance = SystemManager.getInstance();
        assertNotNull(instance, "SystemManager instance should not be null");
    }

    @Test
    public void testRegisterCustomer() {
        String nome = "Mario";
        String cognome = "Rossi";
        Integer matricola = 123;

        systemManager.registerCustomer(nome, cognome, matricola);
        assertTrue(systemManager.findMatricola(matricola), "Matricola should exist after registration");
    }

    @Test
    public void testFindMatricola() {
        Integer matricola = 456;
        systemManager.registerCustomer("Luca", "Bianchi", matricola);

        assertTrue(systemManager.findMatricola(matricola), "Matricola should be found");
        assertFalse(systemManager.findMatricola(999), "Non-existent matricola should not be found");
    }

    @Test
    public void testCalculatePrezzo() {
        Double expectedPrezzo = 0.0;
        Double prezzo = systemManager.calculatePrezzo(false, false, false);
        assertEquals(expectedPrezzo, prezzo, "Prezzo should be zero with no subscriptions");

        // Assuming the activity prices are set somewhere in the DBManager or other parts of the system
        expectedPrezzo = 100.0; // Example value
        prezzo = systemManager.calculatePrezzo(true, false, false);
        assertNotNull(prezzo, "Prezzo should not be null with a valid subscription");
    }

    @Test
    public void testSetSubscription() {
        Integer matricola = 789;
        systemManager.registerCustomer("Giulia", "Verdi", matricola);

        systemManager.setSubscription(matricola, true, false, true);
        Double prezzo = systemManager.getPrezzo(matricola);
        assertNotNull(prezzo, "Prezzo should be calculated for valid subscriptions");
    }

    @Test
    public void testCloseDataBase() {
        assertDoesNotThrow(() -> systemManager.closeDataBase(), "Database should close without exceptions");
    }
}
