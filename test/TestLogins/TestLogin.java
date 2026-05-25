package TestLogins;

import login.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLogin {
    
    // Default constructor (not strictly necessary, but included by IDE)
    public TestLogin() {
    }
    
    // Test for a valid username
    // Expected: username meets format rules (contains "_" and ≤ 5 characters)
    @Test
    public void testValidUsername(){
        Login user = new Login("kyl_1", "", "", "", "");
        assertTrue(user.checkUserName());
    }
    
    // Test for an invalid username
    // Expected: username should fail due to incorrect format
    @Test
    public void testInvalidUsername(){
        Login user = new Login("kyle!!!!!!!", "", "", "", "");
        assertFalse(user.checkUserName());
    }
    
    // Test for a valid password
    // Expected: meets complexity rules (capital letter, number, special char, 8+ chars)
    @Test
    public void testValidPassword(){
        Login user = new Login("", "Ch&&sec@ke99!", "", "", "");
        assertTrue(user.checkPasswordComplexity());
    }
    
    // Test for an invalid password
    // Expected: fails because it does not meet complexity requirements
    @Test
    public void testInvalidPassword(){
        Login user = new Login("", "password", "", "", "");
        assertFalse(user.checkPasswordComplexity());
    }
    
    // Test for valid South African international cell number
    // Expected: must start with +27 and contain 9 digits after
    @Test
    public void testValidCellNumber(){
        Login user = new Login("", "", "+27838968976", "", "");
        assertTrue(user.checkCellPhoneNumber());
    }
    
    // Test for invalid cell number format
    // Expected: fails because it does not follow +27 format
    @Test
    public void testInvalidCellNumber(){
        Login user = new Login("", "", "08966553", "", "");
        assertFalse(user.checkCellPhoneNumber());
    }
    
    // Test successful login
    // Expected: username and password match stored values
    @Test
    public void testLoginSuccessful(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "", "");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    // Test failed login attempt
    // Expected: login should fail due to incorrect credentials
    @Test
    public void testLoginFailed(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "", "");
        assertFalse(user.loginUser("wrongUser", "wrongPass"));
    }
}