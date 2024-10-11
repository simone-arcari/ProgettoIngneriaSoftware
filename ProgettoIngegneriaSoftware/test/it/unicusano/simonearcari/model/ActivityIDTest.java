package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityIDTest {

    @Test
    public void testActivityIDValues() {
        // Verifica che i valori dell'enumerazione siano corretti
        assertEquals(1, ActivityID.NUOTO.getId(), "NUOTO should have ID 1");
        assertEquals(2, ActivityID.ATLETICA.getId(), "ATLETICA should have ID 2");
        assertEquals(3, ActivityID.BODYBUILDING.getId(), "BODYBUILDING should have ID 3");
    }

    @Test
    public void testActivityIDEnumLength() {
        // Verifica che l'enumerazione contenga il numero corretto di valori
        assertEquals(3, ActivityID.values().length, "ActivityID should have 3 values");
    }
}
