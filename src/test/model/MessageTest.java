package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    Message myMessage;
    RecipientList myRecipients;
    Recipient r1;
    Recipient r2;
    Date d1;
    Time t1;
    Status status;

    @BeforeEach
    public void runBefore() {
        myMessage = new Message();
        myRecipients = new RecipientList();
        r1 = new Recipient();
        r2 = new Recipient();
        //TODO: init the status here once enum is resolved

        r1.setFirstName("Jane");
        r1.setLastName("Doe");
        r1.setEmailAddress("jane.doe@gamail.com");

        r2.setFirstName("John");
        r2.setLastName("Smith");
        r2.setEmailAddress("john.smith@gmail.com");
    }

    @Test
    public void testSendToSingleRecipient() {
        myMessage.sendTo(r1);

        assertEquals(1, myMessage.getRecipients().size());
    }

    @Test
    public void testSendToMultipleRecipients() {
        myMessage.sendTo(r1);
        myMessage.sendTo(r2);

        assertEquals(2, myMessage.getRecipients().size());
    }

    @Test
    public void testCompose() {
        myMessage.compose("Hello world!");

        assertEquals("Hello world!", myMessage.getBody());

    }

    @Test
    public void testSetDeliveryTime() {
        myMessage.setDeliveryDate(13, 40, 00);

        assertEquals(t1, myMessage.getDeliveryDate());
    }

    @Test
    public void testSetDeliveryDate() {
        myMessage.setDeliveryDate(2020, 04, 15);

        assertEquals(d1, myMessage.getDeliveryDate());

    }

}