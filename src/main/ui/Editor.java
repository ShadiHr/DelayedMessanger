package ui;

//TODO: learn to use the scanner and make instructions interactive
//TODO: fix up the existing code (borrowed from the teller app)

import model.Message;
import model.MessageQueue;
import model.Recipient;

import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Editor {


    private MessageQueue messages;
    private Message message;
    private Scanner input;

    public Editor() {
        message = new Message();
        messages = new MessageQueue();
        runEditor();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runEditor() {
        String command = null;
        input = new Scanner(System.in);

        init();

        askForRecipient();

        askForMessageBody();

        askForDeliveryDate();

        askForDeliveryTime();

        System.out.println("Would you like to add the following message to the queue?");
        System.out.println("Recipient: " + message.getRecipients().listRecipients());
        System.out.println("Message: " + message.getBody());
        System.out.println("Delivery date: " + message.getDeliveryDate());
        System.out.println("Delivery time: " + message.getDeliveryTime());
        command = input.next();

        if (input.toString().toLowerCase() == "yes") {
            messages.addToQueue(message);
            System.out.println("Your message has been added to the queue. Have a great day!");
        } else {
            System.out.println("Would you like to save this draft?");
        }

    }

    private void askForDeliveryTime() {
        String command;
        System.out.println("Please enter a delivery time (24 hr) in the hh:mm:ss format");
        command = input.next();

        int hour = Integer.parseInt(command.substring(0,2));
        int minute = Integer.parseInt(command.substring(0, 2));
        int second = Integer.parseInt(command.substring(0, 2));

        message.setDeliveryTime(hour, minute, second);
    }

    private void askForDeliveryDate() {
        String command;
        System.out.println("Please enter the date on which you'd like your message delivered in a YYYY MM DD format");
        command = input.next();

        int year = Integer.parseInt(command.substring(0, 4));
        int month = Integer.parseInt(command.substring(0, 2));
        int day = Integer.parseInt(command.substring(0, 2));

        message.setDeliveryDate(year, month, day);
    }

    private void askForMessageBody() {
        String command;
        System.out.println("What would you like to say?");
        command = input.next();

        message.compose(command);
    }

    private void askForRecipient() {
        String command;
        System.out.println("Who would you like to send this message to?");
        command = input.next();
        command = command.toLowerCase();

        Recipient recipient = new Recipient();
        recipient.setEmailAddress(command);

        message.getRecipients().addRecipient(recipient);
    }


    // MODIFIES: this
    // EFFECTS: initializes message
    private void init() {
        message = new Message();
        input = new Scanner(System.in);
    }

}
