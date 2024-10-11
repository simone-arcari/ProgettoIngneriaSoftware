package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtleticaTest {
	@Test
	public void testGetInstance() {
		// Testare se il log è presente (se necessario)
		// Controllo che l'istanza non sia null
		assertNotNull(Atletica.getInstance(), "Atletica instance should not be null");
		assertNotNull(Atletica.getInstance(), "Atletica instance should not be null");
		assertNotNull(Atletica.getInstance(), "Atletica instance should not be null");
	}

    @Test
    public void testSingletonInstance() {
        // Otteniamo due istanze di Atletica
        Atletica instance1 = Atletica.getInstance();
        Atletica instance2 = Atletica.getInstance();

        // Verifica che entrambe le istanze siano la stessa
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void testSettersAndGetters() {
        // Otteniamo l'istanza di Atletica
        Atletica atletica = Atletica.getInstance();

        // Verifica le proprietà iniziali
        assertEquals(ActivityID.ATLETICA, atletica.getId(), "ID should be ATLETICA");
        assertEquals("Atletica", atletica.getNome(), "Name should be 'Atletica'");

        // Modifichiamo le proprietà
        atletica.setNome("Atletica Avanzata");
        atletica.setPrezzo(30.0);

        // Verifica che i nuovi valori siano corretti
        assertEquals("Atletica Avanzata", atletica.getNome(), "Name should be updated");
        assertEquals(30.0, atletica.getPrezzo(), "Price should be updated to 30.0");
    }
}
