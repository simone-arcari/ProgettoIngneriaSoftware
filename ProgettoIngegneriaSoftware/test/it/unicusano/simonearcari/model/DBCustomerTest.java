package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DBCustomerTest {

    @Test
    public void testDBCustomerCreation() {
        // Crea un nuovo DBCustomer
        DBCustomer dbCustomer = new DBCustomer(1, "Mario", "Rossi");

        // Verifica che i valori iniziali siano corretti
        assertEquals(1, dbCustomer.matricola, "Matricola should be 1");
        assertEquals("Mario", dbCustomer.nome, "Name should be Mario");
        assertEquals("Rossi", dbCustomer.cognome, "Surname should be Rossi");
    }
}
