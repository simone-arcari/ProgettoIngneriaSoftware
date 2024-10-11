package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NuotoTest {
	@Test
	public void testGetInstance() {
		// Testare se il log è presente (se necessario)
		// Controllo che l'istanza non sia null
		assertNotNull(Nuoto.getInstance(), "Nuoto instance should not be null");
		assertNotNull(Nuoto.getInstance(), "Nuoto instance should not be null");
		assertNotNull(Nuoto.getInstance(), "Nuoto instance should not be null");
	}

    @Test
    public void testSingletonInstance() {
        // Otteniamo due istanze di Nuoto
    	Nuoto instance1 = Nuoto.getInstance();
    	Nuoto instance2 = Nuoto.getInstance();

        // Verifica che entrambe le istanze siano la stessa
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void testSettersAndGetters() {
        // Otteniamo l'istanza di Nuoto
    	Nuoto nuoto = Nuoto.getInstance();

        // Verifica le proprietà iniziali
        assertEquals(ActivityID.NUOTO, nuoto.getId(), "ID should be NUOTO");
        assertEquals("Atletica", nuoto.getNome(), "Name should be 'Nuoto'");

        // Modifichiamo le proprietà
        nuoto.setNome("Nuoto Avanzato");
        nuoto.setPrezzo(50.0);

        // Verifica che i nuovi valori siano corretti
        assertEquals("Nuoto Avanzato", nuoto.getNome(), "Name should be updated");
        assertEquals(50.0, nuoto.getPrezzo(), "Price should be updated to 50.0");
    }
}
