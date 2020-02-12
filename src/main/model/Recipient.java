package model;

// Represents a recipient having a first and last name, and an email address
public class Recipient {

    private String firstName; //TODO: figure out usage/ is it necessary?
    private String lastName;
    private String emailAddress;

    // EFFECTS: creates a recipient with all empty fields
    public Recipient() {

    }

    // EFFECT: returns recipient's first name
    public String getFirstName() {
        return firstName;
    }

    // EFFECTS: returns recipient's last name
    public String getLastName() {
        return lastName;
    }

    // EFFECTS: returns recipient's email address
    public String getEmailAddress() {
        return emailAddress;
    }

    // MODIFIES: this
    // EFFECTS: recipient's first name is the given string
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // MODIFIES: this
    // EFFECTS: recipient's last name is the given string
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // MODIFIES: this
    // EFFECTS: recipient's email address is the given string
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.toLowerCase();
    }


    // EFFECTS: returns the list of recipients' email addresses
    public String toString() {
        return emailAddress;
    }
}

