package login;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Handles message validation, message ID generation,
 * message hashing, sending, storing, and printing.
 */
public class Messages {
    private String recipient;
    private String message;
    private String messageID;
    private int messageNumber;
    private final Scanner sc;

    /**
     * Creates a Messages object using the recipient cell number
     * and the message text entered by the user.
     */
    public Messages(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.sc = new Scanner(System.in);
        this.messageNumber = 0;
        generateMessageID();
    }

    /**
     * Checks whether the message is within the 250-character limit.
     * @return validation result message
     */
    public String checkMessages() {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extra = message.length() - 250;
            return "Message exceeds 250 characters by " + extra + ", please reduce the size.";
        }
    }

    /**
     * Checks whether the recipient number starts with + and is valid.
     * @return validation result message
     */
    public String checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    /**
     * Generates a random 10-digit message ID.
     * @return generated message ID
     */
    public String generateMessageID() {
        Random rand = new Random();
        long num = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        messageID = String.valueOf(num);
        return messageID;
    }

    /**
     * Checks whether the generated message ID is exactly 10 characters long.
     * @return true if valid, otherwise false
     */
    public boolean checkMessageID() {
        return messageID != null && messageID.length() == 10;
    }

    /**
     * Creates a message hash using the first two digits of the message ID,
     * the message number, and the first and last words of the message.
     * @return uppercase message hash
     */
    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        String firstTwo = messageID.substring(0, 2);
        String hash = firstTwo + ":0:" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    /**
     * Allows the user to choose whether to send, discard, or store the message.
     * @return result message based on user choice
     */
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

    /**
     * Returns all messages sent while the program is running.
     * @return formatted message details
     */
    public String printMessages() {
        return "Message ID: " + messageID + "\nMessage Hash: " + createMessageHash()
                + "\nRecipient: " + recipient + "\nMessage: " + message;
    }

    /**
     * Returns the total number of messages sent.
     * @return total messages sent
     */
    public int returnTotalMessages() {
        return messageNumber;
    }

    /**
     * Stores the message details in a JSON file.
     */
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