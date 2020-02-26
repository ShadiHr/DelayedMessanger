package persistence;

import model.Message;
import model.MessageQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaverTest {
    public static final String TEST_FILE = "data/testMessageQueue.json";
    private Saver testSaver;
    private MessageQueue myMessages;
    private Message m1;
    private Message m2;


    @BeforeEach
    void runBefore() {
        testSaver = new Saver();
        myMessages = new MessageQueue();
        m1 = new Message();
        m2 = new Message();

    }

    @Test
    void testSaveMessages() throws IOException {

        myMessages.addToQueue(m1);
        myMessages.addToQueue(m2);
        testSaver.save(myMessages);

        Loader loader = new Loader();
        MessageQueue loadedMessages = loader.load();

        assertEquals(2, loadedMessages.getQueue().size());

    }

}
