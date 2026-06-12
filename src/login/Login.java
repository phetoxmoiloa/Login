package login;
import java.util.Scanner;

public class Login {
    // Instance variables to store user details
    private String username;
    private String password;
    private String cellNum;
    private String firstName;
    private String lastName;
    
    // Constructor to initialize user information when creating a Login object
    public Login(String username, String password, String cellNum, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.cellNum = cellNum;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Method to check if username is valid
    // Rule: must contain an underscore and be no more than 5 characters long
    public boolean checkUserName(){
        return username.contains("_") && username.length() <= 5;
    }
    
    // Method to check password complexity
    // Rule: at least 8 characters, 1 uppercase letter, 1 number, and 1 special character
    public boolean checkPasswordComplexity(){
        boolean length = password.length() >= 8;
        boolean hasCaps = password.matches(".*[A-Z].*");
        boolean hasNums = password.matches(".*[0-9].*");
        boolean hasSpecChar = password.matches(".*\\W.*");
        return length && hasCaps && hasNums && hasSpecChar;
    }
     
    // Method to validate South African international phone number format
    // Must start with +27 followed by 9 digits
    public boolean checkCellPhoneNumber(){
    return cellNum.matches("\\+\\d{9,}");
    }
    
    // Method used during registration to confirm if all details are valid
    public String registerUser(){
        if(!checkUserName()){
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if(!checkPasswordComplexity()){
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if(!checkCellPhoneNumber()){
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        return "Username successfully captured. Password successfully captured. Cell phone number successfully added.";
    }
    
    // Method to verify login credentials
    public boolean loginUser(String inputUsername, String inputPassword){
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
    
    // Method to return login status message after attempting login
    public String returnLoginStatus(String inputUsername, String inputPassword){
        if(loginUser(inputUsername, inputPassword)){
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
    
    // Main method - entry point of the program
    public static void main(String[] args) {
        // Run unit tests first to verify methods                   
        
        // Collect user registration details
        try (Scanner sc = new Scanner(System.in)) {
            // Collect user registration details
            System.out.println("=== REGISTRATION ===");
            
            System.out.println("Enter your first name: ");
            String firstName = sc.nextLine();
            
            System.out.println("Enter your last name: ");
            String lastName = sc.nextLine();
            
            System.out.println("Enter your username: ");
            String username = sc.nextLine();
            
            System.out.println("Enter your password: ");
            String password = sc.nextLine();
            
            System.out.println("Enter your cellphone number: ");
            String cellNum = sc.nextLine();
            
            // Create Login object using entered details
            Login newLogin = new Login(username, password, cellNum, firstName, lastName);
            
            // Validate registration input
            System.out.println(newLogin.registerUser());
            
            // Login section
            System.out.println("\n=== LOGIN ===");
            
            System.out.println("Enter your username: ");
            String loginUsername = sc.nextLine();
            
            System.out.println("Enter your password: ");
            String loginPassword = sc.nextLine();
            
            // Display login result
            System.out.println(newLogin.returnLoginStatus(loginUsername, loginPassword));
        }
    }
}
    
