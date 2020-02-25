package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.MessageQueue;

import java.io.*;

// A writer that can write messages to a file
public class Saver {

    // EFFECTS: constructs a saver that will write data to file
    public Saver() {

    }

    // MODIFIES: this
    // EFFECTS: saves queue in the given file
    public void save(MessageQueue queue) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter saver = new FileWriter("data/messageQueue.json");
        gson.toJson(queue, saver);
        saver.close();

    }

}



// TODO: add all specifications
// TODO: figure out if this is the right method to throw these exceptions