package ui;


import model.Message;
import model.MessageQueue;
import model.Recipient;
import persistence.Loader;
import persistence.Saver;

import java.io.IOException;
import java.util.Scanner;

// Message editor application
public class Editor {

    private MessageQueue messages;
    private Scanner input;
    private Saver saver;
    private Loader loader;


    // EFFECTS: initiates the editor application with a new, empty message queue
    public Editor() throws IOException {
        loader = new Loader();
        messages = loader.load();
        input = new Scanner(System.in);
        saver = new Saver();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    public void runEditor() throws IOException {
        while (true) {

            System.out.println("To compose a new message, enter 'c'");
            System.out.println("To view the message queue, enter 'v'");
            System.out.println("To quit the menu, enter 'q'");
            String command = input.nextLine();

            if (command.equals("c")) {
                composeMessage();
            } else if (command.equals("v")) {
                viewQueue();

            } else if (command.equals("q")) {
                askToSave();
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
            System.out.println("Your message has been added to the queue.");
        }
    }


    // EFFECTS: displays the queue and provides user the option to filter by recipient
    public void viewQueue() {
        System.out.println(messages);
        System.out.println("Would you like to filter by user?");
        String command = input.nextLine();

        if (command.toLowerCase().equals("yes")) {
            System.out.println("Whose messages would you like to see?");
            String user = input.nextLine();
            System.out.println(messages.filterByRecipient(user));
        }
    }



    // MODIFIES: message
    // EFFECTS: requests user for a delivery time and sets that as the message's delivery time
    private void askForDeliveryTime(Message message) {
        System.out.println("Please enter a delivery time (24 hr) in the hh:mm:ss format");
        message.setDeliveryTime(input.nextLine());

    }

    // MODIFIES: message
    // EFFECTS: requests user for a delivery date and sets that as the message's delivery date
    private void askForDeliveryDate(Message message) {
        System.out.println("Please enter the date on which you'd like your message delivered in a YYYY MM DD format");
        message.setDeliveryDate(input.nextLine());
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

            message.sendTo(command);
        }
    }

    // MODIFIES: .json file
    // EFFECTS: saves message queue to .json file based on user's response
    private void askToSave() throws IOException {
        String command;
        System.out.println("would you like to save your queue?");
        command = input.nextLine();
        if (command.toLowerCase().equals("yes")) {
            saver.save(messages);
        }
        System.out.println("Have a nice day!");
        System.exit(0);
    }

}

