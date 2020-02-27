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
    @Override
    public String toString() {
        String output = "";
        int index = 0;
        for (Message item : getQueue()) {
            index++;
            output += index + " - " + item.getBody() + "\n";
        }
        return output;
    }

    // EFFECTS: filters viewed queued by specific recipient
    public String filterByRecipient(String user) {
        String output = "";
        int index = 0;
        for (Message item : getQueue()) {
            for (Recipient target : item.getRecipients()) {
                if (target.getEmailAddress().equals(user)) {
                    index++;
                    output += index + " - " + item.getBody() + "\n";
                }
            }
        }
        return output;
    }
}
