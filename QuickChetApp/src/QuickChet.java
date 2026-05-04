
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mulis
 */
public class QuickChet {
    
}

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean loggedIn = true; // assume login is successful

        if (!loggedIn) {
            System.out.println("You must log in first.");
            return;
        }

        System.out.println("Welcome to QuickChat.");

        System.out.print("Enter number of messages: ");
        int numMessages = input.nextInt();
        input.nextLine();

        int count = 0;

    OUTER:
    while (true) {
        System.out.println("\n1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1 -> {
                while (count < numMessages) {

                    System.out.print("Enter recipient (+countrycode): ");
                    String recipient = input.nextLine();

                    System.out.print("Enter message: ");
                    String messageText = input.nextLine();

                    System.out.println(Message.validateMessage(messageText));

                    Message msg = new Message(recipient, messageText);

                    System.out.println(msg.checkRecipientCell());

                    System.out.println("\nChoose option:");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");

                    int option = input.nextInt();
                    input.nextLine();

                    System.out.println(msg.SentMessage(option));

                    if (option == 1) {
                        System.out.println(msg.printMessage());
                    }

                    count++;
                }
                System.out.println("\nTotal messages sent: " + Message.returnTotalMessages());
                }
            case 2 -> System.out.println("Coming Soon.");
            case 3 -> {
                System.out.println("Goodbye!");
                break OUTER;
                }
            default -> {
                }
        }
    }
    }
