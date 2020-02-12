package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageQueueTest {
    MessageQueue q1;
    Message m1;
    Message m2;
    Message m3;

    @BeforeEach
    public void runBefore() {
        q1 = new MessageQueue();
        m1 = new Message();
        m2 = new Message();
        m3 = new Message();
    }

    @Test
    public void testAddToQueueSingle() {
        assertTrue(q1.isEmpty());
        q1.addToQueue(m1);

        assertEquals(1, q1.getQueue().size());

        assertFalse(q1.isEmpty());
    }

    @Test
    public void testAddToQueueMultiple() {
        q1.addToQueue(m1);
        q1.addToQueue(m2);
        q1.addToQueue(m3);

        assertEquals(3, q1.getQueue().size());
    }
}



