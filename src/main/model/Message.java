package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Message {

    private String body;
    private ArrayList<Recipient> recipients;
    private Date deliveryDate;
    private Time deliveryTime;
    private Status status;  //TODO: complete the enumeration


   // EFFECTS: composes a new message with empty body
    public Message() {
        body = "";
        recipients = new ArrayList<>();
    }

    // EFFECTS: returns the message body
    public String getBody() {
        return body;
    }

    // EFFECTS: returns message's status
    public Status getStatus() {
        return status;
    }

    // REQUIRES: message must already be scheduled (status: scheduled for delivery)
    // EFFECTS: returns message's delivery time
    public Time
    getDeliveryTime() {
        return deliveryTime;
    }


    // EFFECTS: returns recipient
    public ArrayList<Recipient> getRecipients() {
        return recipients;
    }


    // REQUIRES: message must already be scheduled (status: scheduled for delivery)
    // EFFECTS: returns message's delivery date
    public Date getDeliveryDate() {
        return deliveryDate;
    }



    // MODIFIES: this
    // EFFECTS: assigns the given string to be the message's recipient(s)
    public void sendTo(Recipient r) {
        recipients.add(r);
    }

    // MODIFIES: this
    // EFFECTS: assigns the given string to be the message's body
    public void compose(String body) {
        this.body = body;
    }

    // MODIFIES: this
    // EFFECTS: assigns the given date as message's delivery date
    public void setDeliveryDate(int year, int month, int day) {
        deliveryDate = new Date(year, month, day);
    }

    // MODIFIES: this
    // EFFECTS: assigns teh given time as the message's delivery time
    public void setDeliveryTime(int hour, int minute, int second) {
        deliveryTime = new Time(hour, minute, second);
    }

    // REQUIRES: status is one of "scheduled for delivery", "sent", "draft"
    // MODIFIES: this
    // EFFECTS: assigns the given string as the message's status
    public void setStatus(Status status) {
        this.status = status;
    }

    public String listRecipients() {
        String list = "";
        for (Recipient item : recipients) {
            list = list + item.getEmailAddress() + "; ";
        }
        return list;
    }

}
