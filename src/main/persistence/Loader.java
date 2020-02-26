package persistence;

import com.google.gson.Gson;
import model.MessageQueue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// A reader that can read message data from a file
public class Loader {

    // EFFECTS: constructs a loader that will load data from file
    public Loader() {

    }

    // EFFECTS: returns content of file as a MessageQueue object
    public MessageQueue load() throws IOException {
        Gson gson = new Gson();

        try {
            Reader loader = new FileReader("data/testMessageQueue.json");
            MessageQueue queue = gson.fromJson(loader, MessageQueue.class);
            loader.close();
            return queue;
        } catch (FileNotFoundException e) {
            return new MessageQueue();
        }
    }
}
