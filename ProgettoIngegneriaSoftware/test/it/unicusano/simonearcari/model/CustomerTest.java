package it.unicusano.simonearcari.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        // Crea un nuovo cliente
        Customer customer = new Customer(1, "Mario", "Rossi");

        // Verifica che i valori iniziali siano corretti
        assertEquals(1, customer.getMatricola(), "Matricola should be 1");
        assertEquals("Mario", customer.getNome(), "Name should be Mario");
        assertEquals("Rossi", customer.getCognome(), "Surname should be Rossi");
        assertFalse(customer.isSubscribed(), "Customer should not have a subscription initially");
    }

    @Test
    public void testSetSubscription() {
        // Crea un nuovo cliente
        Customer customer = new Customer(2, "Luigi", "Verdi");

        // Imposta un abbonamento per nuoto e atletica
        customer.setSubscription(true, true, false);

        // Verifica che la sottoscrizione sia stata creata correttamente
        assertTrue(customer.isSubscribed(), "Customer should have a subscription");
        Subscription subscription = customer.getSubscription();
        assertNotNull(subscription, "Subscription should not be null");
        assertTrue(subscription.isNuoto(), "Subscription should include Nuoto");
        assertTrue(subscription.isAtletica(), "Subscription should include Atletica");
        assertFalse(subscription.isBodybuilding(), "Subscription should not include Bodybuilding");

        // Verifica che il proprietario della sottoscrizione sia il cliente
        assertEquals(customer, subscription.getOwner(), "Subscription owner should be the customer");
    }

    @Test
    public void testRemoveSubscription() {
        // Crea un nuovo cliente
        Customer customer = new Customer(3, "Anna", "Bianchi");

        // Imposta un abbonamento per bodybuilding
        customer.setSubscription(false, false, true);

        // Verifica che la sottoscrizione sia stata creata
        assertTrue(customer.isSubscribed(), "Customer should have a subscription");

        // Rimuove la sottoscrizione impostando tutte le attività a false
        customer.setSubscription(false, false, false);

        // Verifica che la sottoscrizione sia stata rimossa
        assertFalse(customer.isSubscribed(), "Customer should not have a subscription after removing all activities");
        assertNull(customer.getSubscription(), "Subscription should be null after removal");
    }

    @Test
    public void testUpdateSubscription() {
        // Crea un nuovo cliente
        Customer customer = new Customer(4, "Carlo", "Neri");

        // Imposta un abbonamento per nuoto
        customer.setSubscription(true, false, false);
        assertTrue(customer.isSubscribed(), "Customer should have a subscription");
        Subscription subscription = customer.getSubscription();
        assertTrue(subscription.isNuoto(), "Subscription should include Nuoto");
        assertFalse(subscription.isAtletica(), "Subscription should not include Atletica");
        assertFalse(subscription.isBodybuilding(), "Subscription should not include Bodybuilding");

        // Aggiorna la sottoscrizione per includere atletica
        customer.setSubscription(true, true, false);
        assertTrue(subscription.isAtletica(), "Subscription should include Atletica after update");

        // Aggiorna la sottoscrizione per rimuovere nuoto e aggiungere bodybuilding
        customer.setSubscription(false, false, true);
        assertFalse(subscription.isNuoto(), "Subscription should not include Nuoto after update");
        assertFalse(subscription.isAtletica(), "Subscription should not include Atletica after update");
        assertTrue(subscription.isBodybuilding(), "Subscription should include Bodybuilding after update");
    }
}
