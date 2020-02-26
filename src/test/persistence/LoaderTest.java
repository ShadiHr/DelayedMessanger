package persistence;

import model.Message;
import model.MessageQueue;
import model.Recipient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderTest {
    Loader loader;
    MessageQueue queue;
    Message m1;
    Message m2;
    Recipient r1;
    Recipient r2;


    @BeforeEach
    void runBefore() throws IOException {
        loader = new Loader();
        queue = new MessageQueue();
        m1 = new Message();
        m2 = new Message();
        r1 = new Recipient();
        r2 = new Recipient();

        m1.sendTo(r1);
        m1.sendTo(r2);
        m1.compose("hello");

        queue.addToQueue(m1);
        Saver saver = new Saver();
        saver.save(queue);


    }

    @Test
    void testLoadMessages() throws IOException {

        MessageQueue output = loader.load();
        assertEquals(2, output.getQueue().get(0).getRecipients().size());


    }

}
