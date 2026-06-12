package login;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
    
        ArrayList<String> sentMessages = new ArrayList<>();
        
        ArrayList<String> disregardedMessages = new ArrayList<>();
        
        ArrayList<String> storedMessages = new ArrayList<>();
        
        ArrayList<String> messageHash = new ArrayList<>();
        
        ArrayList<String> messageIDs = new ArrayList<>();
        
        ArrayList<String> recipients = new ArrayList<>();
        
        ArrayList <String> allMessages = new ArrayList<>();
        
       
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
        
        messageHash.add(createMessageHash());
        messageIDs.add(messageID);
        recipients.add(recipient);
        allMessages.add(message);
        

        switch (choice) {
            case 1:
                sentMessages.add(message);
                messageNumber++;
                System.out.println("Message ID: " + messageID);
                System.out.println("Message Hash: " + createMessageHash());
                System.out.println("Recipient: " + recipient);
                System.out.println("Message: " + message);
                return "Message successfully sent.";
            case 2:
                disregardedMessages.add(message);
                return "Press 0 to delete the message.";
            case 3:
                storedMessages.add(message);
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
    
    public String getLongestMessage(){
        String longest = "";
        for (String msg : storedMessages){
         
        
        if (msg.length() > longest.length()){
                longest = msg;
        }
        }       
      return longest;          
    }
    
    public String searchMessageID(String searchID) {
        for (int i = 0; i < messageIDs.size(); i++){
            
            
        if (messageIDs.get(i).equals(searchID)){
           return recipients.get(i) + allMessages.get(i);
        }
    }
    return "Message not found";  
    }
    
    public String searchRecipientMessages(String searchRecipient){
        String result = "";
        for (int i = 0; i < recipients.size(); i++){
            
        if (recipients.get(i).equals(searchRecipient)){
           result += allMessages.get(i);
        }
        
    }
        return result;
}
    
    public String deleteMessage(String hash){
        
        for (int i = 0; i < messageHash.size(); i++){
            
            if (messageHash.get(i).equals(hash)){
                String deletedMsg = allMessages.get(i);
                messageHash.remove(i); messageIDs.remove(i);
                recipients.remove(i); allMessages.remove(i);
                sentMessages.remove(i); storedMessages.remove(i);
                disregardedMessages.remove(i);
                return "Message: " + deletedMsg + " was successfully deleted";
            }
            
        }
        return "Message not found.";
    }
    
    public String displayReport(){
        String disRep = "";
        for(int i = 0; i < allMessages.size(); i++){
            disRep += allMessages.get(i) + "\n"; disRep += messageHash.get(i) + "\n"; 
            disRep += recipients.get(i);
            
        }
        return disRep;
    }
    public void setRecipient(String recipient) {
            this.recipient = recipient;}
        
        public void setMessage (String message){
            this.message = message;}
        
    public void addTestMessage(String recipient, String message, String flag){
        this.message = message;
        this.recipient = recipient;
        
        
        if (flag.equals("Sent")) {
            sentMessages.add(message);
           }else if (flag.equals("Stored")) {
                storedMessages.add(message);
           } else if (flag.equals("Disregard")){
               disregardedMessages.add(message);
           }
    allMessages.add(message);
    recipients.add(recipient);
    messageIDs.add(generateMessageID());
    messageHash.add(createMessageHash());
}
}


