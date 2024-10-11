package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodybuildingTest {
	@Test
	public void testGetInstance() {
		// Testare se il log è presente (se necessario)
		// Controllo che l'istanza non sia null
		assertNotNull(Bodybuilding.getInstance(), "Bodybuilding instance should not be null");
		assertNotNull(Bodybuilding.getInstance(), "Bodybuilding instance should not be null");
		assertNotNull(Bodybuilding.getInstance(), "Bodybuilding instance should not be null");
	}

    @Test
    public void testSingletonInstance() {
        // Otteniamo due istanze di Bodybuilding
    	Bodybuilding instance1 = Bodybuilding.getInstance();
    	Bodybuilding instance2 = Bodybuilding.getInstance();

        // Verifica che entrambe le istanze siano la stessa
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void testSettersAndGetters() {
        // Otteniamo l'istanza di Bodybuilding
    	Bodybuilding bodybuilding = Bodybuilding.getInstance();

        // Verifica le proprietà iniziali
        assertEquals(ActivityID.BODYBUILDING, bodybuilding.getId(), "ID should be BODYBUILDING");
        assertEquals("Bodybuilding", bodybuilding.getNome(), "Name should be 'Bodybuilding'");

        // Modifichiamo le proprietà
        bodybuilding.setNome("Bodybuilding Avanzato");
        bodybuilding.setPrezzo(70.0);

        // Verifica che i nuovi valori siano corretti
        assertEquals("Bodybuilding Avanzato", bodybuilding.getNome(), "Name should be updated");
        assertEquals(70.0, bodybuilding.getPrezzo(), "Price should be updated to 70.0");
    }
}

	
	
	
	

