package model;

public class Recipient {

    private String firstName; //TODO: figure out usage/ is it necessary?
    private String lastName;
    private String emailAddress;

    public Recipient() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.toLowerCase();
    }

}

