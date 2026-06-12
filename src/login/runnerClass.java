package login;
import java.util.Scanner;

public class runnerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");
        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        System.out.println("Enter cell number:");
        String cellNum = sc.nextLine();

        Login login = new Login(username, password, cellNum, firstName, lastName);
        String registrationResult = login.registerUser();
        System.out.println(registrationResult);

        if (!registrationResult.contains("successfully")) {
            sc.close();
            return;
        }

        System.out.println("\n=== LOGIN ===");
        System.out.println("Enter username:");
        String loginUsername = sc.nextLine();
        System.out.println("Enter password:");
        String loginPassword = sc.nextLine();
        String loginResult = login.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginResult);

        while (loginResult.contains("Welcome")) {
            System.out.println("\nWelcome to QuickChat.");

            Messages msg = new Messages("", "");
            int choice = 0;

            while (choice != 4) {
                System.out.println("\n1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Stored Messages");
                System.out.println("4) Quit");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("How many messages do you want to send?");
                        int numMessages = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("Enter recipient:");
                            String recipient = sc.nextLine();
                            System.out.println("Enter message:");
                            String message = sc.nextLine();
                            msg.setRecipient(recipient);
                            msg.setMessage(message);
                            msg.generateMessageID();
                            System.out.println(msg.checkRecipientCell());
                            System.out.println(msg.sentMessages());
                        }
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        int subChoice = 0;
                        while (subChoice != 6) {
                            System.out.println("\n1) Display all stored messages");
                            System.out.println("2) Display longest message");
                            System.out.println("3) Search by message ID");
                            System.out.println("4) Search by recipient");
                            System.out.println("5) Delete message by hash");
                            System.out.println("6) Back");
                            subChoice = sc.nextInt();
                            sc.nextLine();

                            switch (subChoice) {
                                case 1:
                                    System.out.println(msg.displayReport());
                                    break;
                                case 2:
                                    System.out.println(msg.getLongestMessage());
                                    break;
                                case 3:
                                    System.out.println("Enter message ID:");
                                    String searchID = sc.nextLine();
                                    System.out.println(msg.searchMessageID(searchID));
                                    break;
                                case 4:
                                    System.out.println("Enter recipient:");
                                    String searchRecipient = sc.nextLine();
                                    System.out.println(msg.searchRecipientMessages(searchRecipient));
                                    break;
                                case 5:
                                    System.out.println("Enter message hash:");
                                    String hash = sc.nextLine();
                                    System.out.println(msg.deleteMessage(hash));
                                    break;
                                case 6:
                                    System.out.println("Returning to main menu.");
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Goodbye.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        }
        sc.close();
    }
}