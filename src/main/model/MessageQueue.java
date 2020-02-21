package model;

import java.util.ArrayList;

// Represents a message queue
public class MessageQueue {

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

    // EFFECTS: returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return queue.size() == 0;
    }

}
