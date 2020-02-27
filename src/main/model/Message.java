package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


// Represents a message having a list of recipients, a body, delivery date and time, and a status
public class Message {

    private String body;
    private ArrayList<Recipient> recipients;
    private Date deliveryDate;
    private Time deliveryTime;


   // EFFECTS: composes a new message with an empty body
    public Message() {
        body = "";
        recipients = new ArrayList<>();
    }

    // EFFECTS: returns the message body
    public String getBody() {
        return body;
    }


    // REQUIRES: message must already be scheduled (status: scheduled for delivery)
    // EFFECTS: returns message's delivery time
    public Time getDeliveryTime() {
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
    // EFFECTS: adds the given recipient to message's recipient(s)
    public void sendTo(Recipient r) {
        recipients.add(r);
    }

    // MODIFIES: this
    // EFFECTS: adds the given string to message's recipients(s)
    public void sendTo(String s) {

        Recipient recipient = new Recipient();
        recipient.setEmailAddress(s);
        getRecipients().add(recipient);
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

    // REQUIRES: string pass in the YYYY MM DD form
    // MODIFIES:this
    // EFFECTS: assigns the given string as message's delivery date
    public void setDeliveryDate(String input) {

        int year = Integer.parseInt(input.substring(0, 4)) - 1900;
        int month = Integer.parseInt(input.substring(5, 7)) - 1;
        int day = Integer.parseInt(input.substring(8));

        setDeliveryDate(year, month, day);
    }

    // MODIFIES: this
    // EFFECTS: assigns the given time as the message's delivery time
    public void setDeliveryTime(int hour, int minute, int second) {
        deliveryTime = new Time(hour, minute, second);
    }

    // REQUIRES: string passed in the hh:mm:ss form
    // MODIFIES: this
    // EFFECTS: assigns the given string as the message's delivery time
    public void setDeliveryTime(String input) {

        int hour = Integer.parseInt(input.substring(0, 2));
        int minute = Integer.parseInt(input.substring(3, 5));
        int second = Integer.parseInt(input.substring(6));

        setDeliveryTime(hour, minute, second);
    }

}
