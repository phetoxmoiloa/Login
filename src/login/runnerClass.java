
package login;
import java.util.Scanner;
/**
 *
 * @author pheto
 */
public class runnerClass{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        Login login = new Login(username, password, cellNum, firstName, lastName);
        String isSuccess = login.returnLoginStatus(username, password);

        if (isSuccess.contains("Welcome ")) {
            System.out.println("Welcome to QuickChat.");
            
            System.out.println("How many messages do you want to send?");
            int numMessages = sc.nextInt();
            
            int choice = 0;
            while (choice != 3) {
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("Enter recipient:");
                            String recipient = sc.nextLine();
                            System.out.println("Enter message:");
                            String message = sc.nextLine();

                            Messages msg = new Messages(recipient, message);
                            System.out.println(msg.checkRecipientCell());
                            System.out.println(msg.sentMessages());
                        }
                        break;
                    case 2:
                        System.out.println("Coming Soon.");
                        break;
                    case 3:
                        System.out.println("Goodbye.");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
        sc.close();
    }
}
    

