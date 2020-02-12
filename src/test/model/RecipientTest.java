package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientTest {
    Recipient recipient;

    @BeforeEach
    public void runBefore() {
        recipient = new Recipient();
    }

    @Test
    public void testSetFirstName() {
        recipient.setFirstName("Ali");

        assertEquals("Ali", recipient.getFirstName());
    }

    @Test
    public void testSetLastName() {
        recipient.setLastName("Smith");

        assertEquals("Smith", recipient.getLastName());
    }

    @Test
    public void testSetEmailAddressAllLowerCase() {
        recipient.setEmailAddress("ali.smith@gmail.com");

        assertEquals("ali.smith@gmail.com", recipient.getEmailAddress());
    }

    @Test
    public void testSetEmailAddressSomeUpperCase() {
        recipient.setEmailAddress("Ali.Smith@gmail.com");

        assertEquals("ali.smith@gmail.com", recipient.getEmailAddress());
    }

    @Test
    public void testToString() {
        recipient.setFirstName("Jimmy");
        recipient.setLastName("Smith");
        recipient.setEmailAddress("jimmy.smith@gmail.com");

        assertEquals("jimmy.smith@gmail.com", recipient.toString());
    }
}

// TODO: add more tests for 100% coverage
