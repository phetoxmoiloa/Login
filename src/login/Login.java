package login;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;
    private String cellNum;
    private String firstName;
    private String lastName;
    
    public Login(String username, String password, String cellNum, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.cellNum = cellNum;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public boolean checkUserName(){
        return username.contains("_") && username.length() <= 5;
    }
    
    public boolean checkPasswordComplexity(){
        boolean length = password.length() >= 8;
        boolean hasCaps = password.matches(".*[A-Z].*");
        boolean hasNums = password.matches(".*[0-9].*");
        boolean hasSpecChar = password.matches(".*\\W.*");
        return length && hasCaps && hasNums && hasSpecChar;
    }
     
    public boolean checkCellPhoneNumber(){
        return cellNum.matches("\\+27\\d{9}");
    }
    
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
    
    public boolean loginUser(String inputUsername, String inputPassword){
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
    
    public String returnLoginStatus(String inputUsername, String inputPassword){
        if(loginUser(inputUsername, inputPassword)){
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
    
    public static void unitTesting(){
        System.out.println(">>>UNIT TESTING<<<");
        
        Login user1 = new Login("kyl_1","","","","");
        System.out.println("kyl_1 valid: " + user1.checkUserName());
        
        Login user2 = new Login("kyle!!!!!!!", "", "", "", "");
        System.out.println("kyle!!!!!!! invalid: " + !user2.checkUserName());
        
        Login user3 = new Login("", "Ch&&sec@ke99!", "","","");
        System.out.println("Ch&&sec@ke99! valid: " + user3.checkPasswordComplexity());
        
        Login user4 = new Login("", "password", "", "", "");
        System.out.println("password invalid: " + !user4.checkPasswordComplexity());
        
        Login user5 = new Login("", "", "+27838968976", "", "");
        System.out.println("+27838968976 valid: " + user5.checkCellPhoneNumber());
        
        Login user6 = new Login("", "", "08966553", "", "");
        System.out.println("08966553 invalid: " + !user6.checkCellPhoneNumber());
        
        Login user7 = new Login("kyl_1", "Ch&&sec@ke99!", "", "", "");
        System.out.println("Login successful: " + user7.loginUser("kyl_1", "Ch&&sec@ke99!"));
        
        System.out.println("Login failed: " + !user7.loginUser("wrongUser", "wrongPass"));
        
        System.out.println("===UNIT TESTING COMPLETE===");
    }
    
    public static void main(String[] args) {
        unitTesting();
        
        Scanner sc = new Scanner(System.in);
        
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
        
        Login newLogin = new Login(username, password, cellNum, firstName, lastName);
        System.out.println(newLogin.registerUser());
        
        System.out.println("\n=== LOGIN ===");
        System.out.println("Enter your username: ");
        String loginUsername = sc.nextLine();
        
        System.out.println("Enter your password: ");
        String loginPassword = sc.nextLine();
        
        System.out.println(newLogin.returnLoginStatus(loginUsername, loginPassword));
        
        sc.close();
    }
}
    
