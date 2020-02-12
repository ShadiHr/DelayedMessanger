package model;

import java.util.ArrayList;

// Represents a message queue with a maximum number of items it can take
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

// TODO: learn about java queue and utilize here instead
