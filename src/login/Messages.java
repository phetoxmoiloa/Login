package login;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Messages {
    private String recipient;
    private String message;
    private String messageID;
    private int messageNumber;
    private final Scanner sc;

    public Messages(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.sc = new Scanner(System.in);
        this.messageNumber = 0;
        generateMessageID();
    }

    public String checkMessages() {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extra = message.length() - 250;
            return "Message exceeds 250 characters by " + extra + ", please reduce the size.";
        }
    }

    public String checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String generateMessageID() {
        Random rand = new Random();
        long num = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        messageID = String.valueOf(num);
        return messageID;
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() == 10;
    }

    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        String firstTwo = messageID.substring(0, 2);
        String hash = firstTwo + ":0:" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    public String sentMessages() {
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                messageNumber++;
                System.out.println("Message ID: " + messageID);
                System.out.println("Message Hash: " + createMessageHash());
                System.out.println("Recipient: " + recipient);
                System.out.println("Message: " + message);
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {
        return "Message ID: " + messageID + "\nMessage Hash: " + createMessageHash()
                + "\nRecipient: " + recipient + "\nMessage: " + message;
    }

    public int returnTotalMessages() {
        return messageNumber;
    }

    public void storeMessage() {
        try (FileWriter fw = new FileWriter("messages.json", true)) {
            String json = "{"
                    + "\"messageID\":\"" + messageID + "\","
                    + "\"recipient\":\"" + recipient + "\","
                    + "\"message\":\"" + message.replace("\"", "\\\"") + "\","
                    + "\"messageHash\":\"" + createMessageHash() + "\""
                    + "}\n";
            fw.write(json);
        } catch (IOException e) {
            System.out.println("Error storing message.");
        }
    }
}