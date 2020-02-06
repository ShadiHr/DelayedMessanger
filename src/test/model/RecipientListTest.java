package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientListTest {
    RecipientList recipientList;
    Recipient r1;
    Recipient r2;
    Recipient r3;

    @BeforeEach
    public void runBefore() {
        recipientList = new RecipientList();
        r1 = new Recipient();
        r2 = new Recipient();
        r3 = new Recipient();

        r1.setFirstName("Sam");
        r2.setFirstName("Jim");
        r3.setFirstName("Jane");

        r1.setLastName("Doe");
        r2.setLastName("James");
        r3.setLastName("Smith");

        r1.setEmailAddress("sam.doe@gmail.com");
        r2.setEmailAddress("jim.james@gmail.com");
        r3.setEmailAddress("jane.smith@gmail.com");

    }

    @Test
    public void testAddSingleRecipient() {
        assertEquals(0, recipientList.size());
        recipientList.addRecipient(r1);
        assertEquals(1, recipientList.size());
    }

    @Test
    public void testAddMultipleRecipients() {
        recipientList.addRecipient(r1);
        recipientList.addRecipient(r2);
        recipientList.addRecipient(r3);

        assertEquals(3, recipientList.size());
    }

    @Test
    public void testRemoveSingleRecipient() {
        recipientList.addRecipient(r1);

        recipientList.removeRecipient(r1);
        assertEquals(0, recipientList.size());
    }

    @Test
    public void testRemoveMultipleRecipients() {
        recipientList.addRecipient(r1);
        recipientList.addRecipient(r2);
        recipientList.addRecipient(r3);

        assertEquals(3, recipientList.size());

        recipientList.removeRecipient(r2);
        recipientList.removeRecipient(r1);

        assertEquals(1, recipientList.size());

    }
}
