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

    // EFFECTS: displays the queue as an enumerated list containing the message bodies
    public void printQueue() {
        String output = "";
        int index = 0;
        for (Message item : getQueue()) {
            index++;
            output += index + " - " + item.getBody() + "\n";
        }
        System.out.println(output);
    }
}
