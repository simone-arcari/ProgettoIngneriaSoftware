package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DBActivityTest {

    @Test
    public void testDBActivityCreation() {
        // Crea un nuovo DBActivity
        DBActivity dbActivity = new DBActivity(1, "Atletica", 20.0);

        // Verifica che i valori iniziali siano corretti
        assertEquals(1, dbActivity.id, "ID should be 1");
        assertEquals("Atletica", dbActivity.nome, "Name should be Atletica");
        assertEquals(20.0, dbActivity.prezzo, "Price should be 20.0");
    }
}
