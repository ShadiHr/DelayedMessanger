package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Message;
import model.MessageQueue;

import java.io.*;
import java.util.ArrayList;

// A writer that can write messages to a file
public class Saver {

    // EFFECTS: constructs a saver that will write data to file
    public Saver() {

    }

    // MODIFIES: this
    // EFFECTS: saves queue to file
    public void save(ArrayList<Message> queue) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter saver = new FileWriter("data/testMessageQueue.json");
        gson.toJson(queue, saver);
        saver.close();

    }

    // MODIFIES: this
    // EFFECTS: saves queue to file
    public void save(MessageQueue queue) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter saver = new FileWriter("data/testMessageQueue.json");
        gson.toJson(queue, saver);
        saver.close();
    }
}


