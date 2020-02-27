package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageQueueTest {
    MessageQueue q1;
    Message m1;
    Message m2;
    Message m3;
    Recipient r1;
    Recipient r2;
    Recipient r3;

    @BeforeEach
    public void runBefore() {
        q1 = new MessageQueue();
        m1 = new Message();
        m2 = new Message();
        m3 = new Message();
        r1 = new Recipient();
        r2 = new Recipient();
        r3 = new Recipient();
    }

    @Test
    public void testAddToQueueSingle() {

        q1.addToQueue(m1);

        assertEquals(1, q1.getQueue().size());

    }

    @Test
    public void testAddToQueueMultiple() {
        q1.addToQueue(m1);
        q1.addToQueue(m2);
        q1.addToQueue(m3);

        assertEquals(3, q1.getQueue().size());
    }

    @Test
    public void testToStringEmpty() {

        assertEquals(0, q1.getQueue().size());

        assertEquals("", q1.toString());
    }

    @Test
    public void testToString() {

        m1.compose("let's go");
        m2.compose("see you tomorrow");
        m3.compose("hello");

        q1.addToQueue(m1);
        q1.addToQueue(m2);
        q1.addToQueue(m3);

        assertEquals(3, q1.getQueue().size());

        String output = "1 - let's go\n" + "2 - see you tomorrow\n" + "3 - hello\n";

        assertEquals(output, q1.toString());
    }

    @Test
    public void testFilterByRecipientNotFoundSingleRecipients() {
        r1.setEmailAddress("sam@gmail.com");
        r2.setEmailAddress("john@gmail.com");
        r3.setEmailAddress("sarah@gmail.com");

        m1.sendTo(r1);
        q1.addToQueue(m1);

        m2.sendTo(r2);
        q1.addToQueue(m2);

        assertEquals("", q1.filterByRecipient("sarah@gmail.com"));
    }

    @Test
    public void testFilterByRecipientNotFoundMultipleRecipients() {
        r1.setEmailAddress("sam@gmail.com");
        r2.setEmailAddress("john@gmail.com");
        r3.setEmailAddress("sarah@gmail.com");

        m1.sendTo(r1);
        m1.sendTo(r2);
        q1.addToQueue(m1);

        m2.sendTo(r2);
        q1.addToQueue(m2);

        assertEquals("", q1.filterByRecipient("sarah@gmail.com"));
    }

    @Test
    public void testFilterByRecipientFound() {

        m1.compose("let's go");
        m2.compose("see you tomorrow");
        m3.compose("hello");

        q1.addToQueue(m1);
        q1.addToQueue(m2);
        q1.addToQueue(m3);

        r1.setEmailAddress("sam@gmail.com");
        r2.setEmailAddress("john@gmail.com");
        r3.setEmailAddress("sarah@gmail.com");

        m1.sendTo(r1);
        m1.sendTo(r2);

        m2.sendTo(r2);
        m2.sendTo(r3);

        m3.sendTo(r3);

        String output = "1 - see you tomorrow\n" + "2 - hello\n";
        assertEquals(output, q1.filterByRecipient("sarah@gmail.com"));

    }
}



