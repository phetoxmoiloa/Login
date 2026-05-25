package login;

import java.util.Scanner;

/**
 * Main runner class for the QuickChat application.
 * Handles user login, menu navigation, and message entry.
 *
 * @author pheto
 */
public class runnerClass {
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);

        // Collect login details from the user
        System.out.println("Enter username:");
        String username = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        System.out.println("Enter first name:");
        String firstName = sc.nextLine();

        System.out.println("Enter last name:");
        String lastName = sc.nextLine();

        System.out.println("Enter cell number:");
        String cellNum = sc.nextLine();

        // Create Login object and validate login details
        Login login = new Login(username, password, cellNum, firstName, lastName);
        String isSuccess = login.returnLoginStatus(username, password);

        // If login is successful, show the QuickChat menu
        if (isSuccess.contains("Welcome ")) {
            System.out.println("Welcome to QuickChat.");

            // Ask the user how many messages they want to send
            System.out.println("How many messages do you want to send?");
            int numMessages = sc.nextInt();

            int choice = 0;

            // Keep showing the menu until the user chooses to quit
            while (choice != 3) {
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        // Allow the user to enter the set number of messages
                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("Enter recipient:");
                            String recipient = sc.nextLine();

                            System.out.println("Enter message:");
                            String message = sc.nextLine();

                            // Create a Messages object for each entry
                            Messages msg = new Messages(recipient, message);

                            // Validate recipient and process the message
                            System.out.println(msg.checkRecipientCell());
                            System.out.println(msg.sentMessages());
                        }
                        break;

                    case 2:
                        // Feature still under development
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        // Exit the application
                        System.out.println("Goodbye.");
                        break;

                    default:
                        // Handle invalid menu choices
                        System.out.println("Invalid option.");
                }
            }
        } else {
            // Display login failure message
            System.out.println("Login failed. Incorrect username or password.");
        }

        // Close scanner
        sc.close();
    }
}
    

