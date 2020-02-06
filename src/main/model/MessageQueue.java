package model;

import java.util.ArrayList;

public class MessageQueue {

    private ArrayList<Message> queue;

    public MessageQueue() {
        queue = new ArrayList<>();
    }

    public ArrayList<Message> getQueue() {
        return queue;
    }

    public void addToQueue(Message m) {
        queue.add(m);
    }
}
