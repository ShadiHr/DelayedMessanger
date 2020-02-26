package model;

import persistence.Saver;

import java.io.IOException;
import java.util.ArrayList;

// Represents a message queue
public class MessageQueue implements Saveable {

    private ArrayList<Message> queue;

    // EFFECTS: creates an empty queue
    public MessageQueue() {
        queue = new ArrayList<>();
    }

    // REQUIRES: a non-empty queue
    // EFFECTS: returns the queue
    public ArrayList<Message> getQueue() {
        return queue;
    }

    // MODIFIES: this
    // EFFECTS: adds given message to the queue
    public void addToQueue(Message m) {
        queue.add(m);
    }

    @Override
    public void save() throws IOException {
        Saver saver = new Saver();
        saver.save(queue);
    }
}
