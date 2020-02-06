package model;

import java.util.ArrayList;

public class RecipientList {

    private ArrayList<Recipient> recipients;

    public RecipientList() {
        recipients = new ArrayList<>();
    }

    public String listRecipients() {
        String recipientList = "";
        for (Recipient r : recipients) {
            recipientList = recipientList + r.getEmailAddress() + "; ";
        }
        return recipientList;
    }

    public void addRecipient(Recipient r) {
        recipients.add(r);
    }

    // REQUIRES: non-empty list of recipients
    public void removeRecipient(Recipient r) {
        recipients.remove(r);
    }

    public int size() {
        return recipients.size();
    }

}
