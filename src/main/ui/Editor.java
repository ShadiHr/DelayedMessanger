package ui;


import model.Message;
import model.MessageQueue;
import model.Recipient;

import javax.swing.*;
import java.util.Scanner;

// Message editor application
public class Editor {

    private MessageQueue messages;
    private Scanner input;

    // EFFECTS: initiates the editor application with a new, empty message queue
    public Editor() {
        messages = new MessageQueue();
        input = new Scanner(System.in);
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    public void runEditor() {   //TODO: make a permanent while true loop so data is not lost (add quit cue)
        while (true) {

            System.out.println("To compose a new message, enter 'c'");
            System.out.println("To view the message queue, enter 'v'");
            System.out.println("To quit the menu, enter 'q'");
            String command = input.nextLine();

            if (command.equals("c")) {
                composeMessage();
            } else if (command.equals("v")) {
                printQueue();
            } else if (command.equals("q")) {
                System.out.println("Have a nice day!");
                System.exit(0);
            }

        }

    }

    // MODIFIES: this
    // EFFECT: process user input to compose a new message
    public void composeMessage() {

        Message message = new Message();

        askForRecipient(message);

        askForMessageBody(message);

        askForDeliveryDate(message);

        askForDeliveryTime(message);

        System.out.println("Would you like to add the following message to the queue?");
        System.out.println("Recipient: " + message.getRecipients());
        System.out.println("Message: " + message.getBody());
        System.out.println("Delivery date: " + message.getDeliveryDate());
        System.out.println("Delivery time: " + message.getDeliveryTime());
        String command = input.nextLine();

        if (command.toLowerCase().equals("yes")) {
            messages.addToQueue(message);
            System.out.println("Your message has been added to the queue. Have a great day!");
        }
//        else {
//            System.out.println("Would you like to save this draft?");  //TODO: get rid of the draft concept for now
//        }
    }


    public void printQueue() {
        String output = "";
        int index = 0;
        for (Message item : messages.getQueue()) {
            index++;
            output += index + " - " + item.getBody() + "\n";
        }
        System.out.println(output);
    }

    // MODIFIES: message
    // EFFECTS: requests user for a delivery time and sets that as the message's delivery time
    private void askForDeliveryTime(Message message) {
        String command;
        System.out.println("Please enter a delivery time (24 hr) in the hh:mm:ss format");
        command = input.nextLine();

        int hour = Integer.parseInt(command.substring(0, 2));
        int minute = Integer.parseInt(command.substring(3, 5));
        int second = Integer.parseInt(command.substring(6));

        message.setDeliveryTime(hour, minute, second);
    }

    // MODIFIES: message
    // EFFECTS: requests user for a delivery date and sets that as the message's delivery date
    private void askForDeliveryDate(Message message) {
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
    private void askForMessageBody(Message message) {
        String command;
        System.out.println("What would you like to say?");
        command = input.nextLine();

        message.compose(command);
    }

    // MODIFIES: message
    // EFFECTS: requests user for recipients and adds them to message's recipients
    private void askForRecipient(Message message) {
        while (true) {
            System.out.println("Please enter an email address: (enter 'q' to quit)");
            String command = input.nextLine();

            if (command.equals("q")) {
                break;
            }

            Recipient recipient = new Recipient();
            recipient.setEmailAddress(command);
            message.getRecipients().add(recipient);

        }
    }

}

