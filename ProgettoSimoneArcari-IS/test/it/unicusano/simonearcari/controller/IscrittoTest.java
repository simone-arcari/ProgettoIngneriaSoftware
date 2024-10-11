package it.unicusano.simonearcari.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IscrittoTest {

    private Iscritto iscritto;

    @BeforeEach
    public void setUp() {
        // Inizializza un oggetto Iscritto prima di ogni test
        iscritto = new Iscritto(12345, "Mario", "Rossi");
    }

    @Test
    public void testGetMatricola() {
        // Testa il getter per la matricola
        assertEquals(12345, iscritto.getMatricola());
    }

    @Test
    public void testSetMatricola() {
        // Testa il setter per la matricola
        iscritto.setMatricola(67890);
        assertEquals(67890, iscritto.getMatricola());
    }

    @Test
    public void testGetNome() {
        // Testa il getter per il nome
        assertEquals("Mario", iscritto.getNome());
    }

    @Test
    public void testSetNome() {
        // Testa il setter per il nome
        iscritto.setNome("Giovanni");
        assertEquals("Giovanni", iscritto.getNome());
    }

    @Test
    public void testGetCognome() {
        // Testa il getter per il cognome
        assertEquals("Rossi", iscritto.getCognome());
    }

    @Test
    public void testSetCognome() {
        // Testa il setter per il cognome
        iscritto.setCognome("Bianchi");
        assertEquals("Bianchi", iscritto.getCognome());
    }
}
