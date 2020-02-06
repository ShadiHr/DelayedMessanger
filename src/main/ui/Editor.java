package ui;


import model.Message;
import model.MessageQueue;
import model.Recipient;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

// Message editor application
public class Editor {

    private MessageQueue messages;
    private Message message;
    private Scanner input;

    // EFFECTS: initiates the editor application with a new empty message and an empty queue
    public Editor() {
        message = new Message();
        messages = new MessageQueue();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    public void runEditor() {   //TODO: make a permanent while true loop so data is not lost (add quit cue)
        input = new Scanner(System.in);

        askForRecipient();

        askForMessageBody();

        askForDeliveryDate();

        askForDeliveryTime();

        System.out.println("Would you like to add the following message to the queue?");
        System.out.println("Recipient: " + message.listRecipients());
        System.out.println("Message: " + message.getBody());
        System.out.println("Delivery date: " + message.getDeliveryDate());
        System.out.println("Delivery time: " + message.getDeliveryTime());
        String command = input.nextLine();

        if (command.toLowerCase().equals("yes")) {
            messages.addToQueue(message);
            System.out.println("Your message has been added to the queue. Have a great day!");
        } else {
            System.out.println("Would you like to save this draft?");  //TODO: get rid of the draft concept for now
        }

    }

    // MODIFIES: message
    // EFFECTS: requests user for a delivery time and sets that as the message's delivery time
    private void askForDeliveryTime() {
        String command;
        System.out.println("Please enter a delivery time (24 hr) in the hh:mm:ss format");
        command = input.nextLine();

        int hour = Integer.parseInt(command.substring(0,2));
        int minute = Integer.parseInt(command.substring(3, 5));
        int second = Integer.parseInt(command.substring(6));

        message.setDeliveryTime(hour, minute, second);
    }

    // MODIFIES: message
    // EFFECTS: requests user for a delivery date and sets that as the message's delivery date
    private void askForDeliveryDate() {
        String command;
        System.out.println("Please enter the date on which you'd like your message delivered in a YYYY MM DD format");
        command = input.nextLine();

        int year = Integer.parseInt(command.substring(0, 4)) - 1900;
        int month = Integer.parseInt(command.substring(5, 7)) - 1;
        int day = Integer.parseInt(command.substring(8));

        message.setDeliveryDate(year, month, day);
    }

    // MODIFIES: message
    // EFFECTS: requests user for content and sets that as the message's body
    private void askForMessageBody() {
        String command;
        System.out.println("What would you like to say?");
        command = input.nextLine();

        message.compose(command);
    }

    // MODIFIES: message
    // EFFECTS: requests user for recipients and adds them to message's recipients
    private void askForRecipient() {
        String command;
        System.out.println("Who would you like to send this message to?");
        command = input.nextLine();
        command = command.toLowerCase();

        Recipient recipient = new Recipient();
        recipient.setEmailAddress(command);

        message.getRecipients().add(recipient);
    }

}
 // TODO: make sure that helper functions are doing one thing at a time
