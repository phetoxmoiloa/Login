package TestLogins;
import login.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLogin {
    
    public TestLogin() {
    }
    
    @Test
    public void testValidUsername(){
        Login user = new Login("kyl_1", "", "", "", "");
        assertTrue(user.checkUserName());
    }
    
    @Test
    public void testInvalidUsername(){
        Login user = new Login("kyle!!!!!!!", "", "", "", "");
        assertFalse(user.checkUserName());
    }
    
    @Test
    public void testValidPassword(){
        Login user = new Login("", "Ch&&sec@ke99!", "", "", "");
        assertTrue(user.checkPasswordComplexity());
    }
    
    @Test
    public void testInvalidPassword(){
        Login user = new Login("", "password", "", "", "");
        assertFalse(user.checkPasswordComplexity());
    }
    
    @Test
    public void testValidCellNumber(){
        Login user = new Login("", "", "+27838968976", "", "");
        assertTrue(user.checkCellPhoneNumber());
    }
    
    @Test
    public void testInvalidCellNumber(){
        Login user = new Login("", "", "08966553", "", "");
        assertFalse(user.checkCellPhoneNumber());
    }
    
    @Test
    public void testLoginSuccessful(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "", "");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailed(){
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "", "");
        assertFalse(user.loginUser("wrongUser", "wrongPass"));
    }
}
