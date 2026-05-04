
import java.io.FileWriter;
import java.io.IOException;
import javax.lang.model.SourceVersion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mulis
 */
public final class Message {

    static String returnTotalMessages() {
        throw new UnsupportedOperationException("supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }


    private static int totalMessages = 0;
    private static int messageCounter = 0;

    private final String messageID;
    private final String recipient;
    private final String message;
    private final String messageHash;

    // Constructor
    public Message(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate ID
    private String generateMessageID() {
        return String.format("%010d", messageCounter++);
    }

    // Check ID
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // Validate recipient
    public String checkRecipientCell() {
        if (recipient.startsWith("+") && recipient.length() <= 10) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Create hash
    public String createMessageHash() {
        String[] words = message.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return messageID.substring(0, 2) + ":" + messageCounter + ":" +
                (firstWord + lastWord).toUpperCase();
    }

    // Send / Discard / Store
    public String SentMessage(int choice) {
        switch (choice) {
            case 1 -> {
                totalMessages++;
                return "Message successfully sent.";
            }
            case 2 -> {
                return "Press 0 to delete the message.";
            }
            case 3 -> {
                storeMessage();
                return "Message successfully stored.";
            }
            default -> {
                return "Invalid option.";
            }
        }
    }

    // Print message
    public String printMessage() {
        return "\nMessage ID: " + messageID +
               "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage: " + message;
    }

    // Total messages
  


    // Validate message length
    public static String validateMessage(String msg) {
        if (msg.length() <= 250) {
            return "Message ready to send.";
        } else {
            return "Message exceeds 250 characters by " + (msg.length() - 250) + ", please reduce the size.";
        }
    }

    // Store JSON
    public void storeMessage() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("MessageID", messageID);
            obj.put("Hash", messageHash);
            obj.put("Recipient", recipient);
            obj.put("Message", message);

            JSONArray list = new JSONArray();
            list.add();

            try (FileWriter file = new FileWriter("messages.json", true)) {
                file.write(list.toJSONString());
            }

        } catch (IOException e) {
            System.out.println("Error saving message.");
        }
    }

    private static class JSONArray {

        public JSONArray() {
        }

        private char[] toJSONString() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void add() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}