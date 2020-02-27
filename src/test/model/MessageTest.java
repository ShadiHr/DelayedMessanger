package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    Message myMessage;
    ArrayList<Recipient> myRecipients;
    Recipient r1;
    Recipient r2;
    String s1;
    String s2;

    @BeforeEach
    public void runBefore() {
        myMessage = new Message();
        myRecipients = new ArrayList<>();
        r1 = new Recipient();
        r2 = new Recipient();
        s1 = "hallie.smith@gmail.com";
        s2 = "kimmy.brown@gmail.com";


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
    public void testSendToStringSingle() {
        myMessage.sendTo(s1);

        assertEquals("hallie.smith@gmail.com", myMessage.getRecipients().get(0).getEmailAddress());
    }

    @Test
    public void testSendToStringMultiple() {
        myMessage.sendTo(s1);
        myMessage.sendTo(s2);

        assertEquals(2, myMessage.getRecipients().size());

        assertEquals("kimmy.brown@gmail.com", myMessage.getRecipients().get(1).getEmailAddress());
    }

    @Test
    public void testCompose() {
        myMessage.compose("Hello world!");

        assertEquals("Hello world!", myMessage.getBody());

    }

    @Test
    public void testSetDeliveryTime() {
        myMessage.setDeliveryTime(13, 40, 00);

        assertEquals(new Time(13, 40, 00), myMessage.getDeliveryTime());
    }

    @Test
    public void testSetDeliveryDate() {
        myMessage.setDeliveryDate(2020, 04, 15);

        assertEquals(new Date(2020, 04, 15 ), myMessage.getDeliveryDate());

    }

}