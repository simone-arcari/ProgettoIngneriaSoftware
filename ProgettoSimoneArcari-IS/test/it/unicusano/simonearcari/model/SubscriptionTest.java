package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionTest {

    @Test
    public void testSubscriptionCreation() {
        // Crea una nuova sottoscrizione
        Subscription subscription = new Subscription(true, false, true);

        // Verifica se le attività sono impostate correttamente
        assertTrue(subscription.isNuoto(), "Subscription should include Nuoto");
        assertFalse(subscription.isAtletica(), "Subscription should not include Atletica");
        assertTrue(subscription.isBodybuilding(), "Subscription should include Bodybuilding");
        
        subscription = new Subscription(false, true, false);

        // Verifica se le attività sono impostate correttamente
        assertFalse(subscription.isNuoto(), "Subscription should include Nuoto");
        assertTrue(subscription.isAtletica(), "Subscription should not include Atletica");
        assertFalse(subscription.isBodybuilding(), "Subscription should include Bodybuilding");
    }

    @Test
    public void testSetOwner() {
        Subscription subscription = new Subscription(true, true, true);
        Customer customer = new Customer(1, "Mario",  "Rossi");

        subscription.setOwner(customer);
        
        // Verifica che il proprietario sia impostato correttamente
        assertEquals(customer, subscription.getOwner(), "Owner should be Mario Rossi");
    }

    @Test
    public void testGetPrezzo() {
        // Crea un'istanza di Subscription
        Subscription subscription = new Subscription(true, true, true);

        // Imposta i prezzi delle attività sportive per il test
        // Supponiamo che i metodi getPrezzo() restituiscano i seguenti valori
        Nuoto.getInstance().setPrezzo(20.0);
        Atletica.getInstance().setPrezzo(30.0);
        Bodybuilding.getInstance().setPrezzo(25.0);

        // Calcola il prezzo totale
        Double expectedPrice = 20.0 + 30.0 + 25.0;
        assertEquals(expectedPrice, subscription.getPrezzo(), "Total price should be 75.0");

        // Modifica l'abbonamento per escludere Atletica
        subscription.setAtletica(false);
        expectedPrice = 20.0 + 25.0; // Nuoto e Bodybuilding
        assertEquals(expectedPrice, subscription.getPrezzo(), "Total price should be 45.0 after excluding Atletica");
    }

    @Test
    public void testSetters() {
        Subscription subscription = new Subscription(false, false, false);

        // Imposta le attività
        subscription.setNuoto(true);
        subscription.setAtletica(true);
        subscription.setBodybuilding(true);

        assertTrue(subscription.isNuoto(), "Subscription should include Nuoto after setting");
        assertTrue(subscription.isAtletica(), "Subscription should include Atletica after setting");
        assertTrue(subscription.isBodybuilding(), "Subscription should include Bodybuilding after setting");
    }

    @Test
    public void testGetPrezzoWithNoActivities() {
        Subscription subscription = new Subscription(false, false, false);

        // Verifica che il prezzo sia 0 quando non ci sono attività
        assertEquals(0.0, subscription.getPrezzo(), "Total price should be 0.0 when no activities are included");
    }
}
