
package login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {
    
    public MessagesTest() {
    }

    /**
     * Test of checkMessages method, of class Messages.
     */
    @Test
    public void testCheckMessages() {
        System.out.println("checkMessages");
        Messages instance = null;
        String expResult = "";
        String result = instance.checkMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Messages.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Messages instance = null;
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateMessageID method, of class Messages.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Messages instance = null;
        String expResult = "";
        String result = instance.generateMessageID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class Messages.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Messages instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Messages.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Messages instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessages method, of class Messages.
     */
    @Test
    public void testSentMessages() {
        System.out.println("sentMessages");
        Messages instance = null;
        String expResult = "";
        String result = instance.sentMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class Messages.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Messages instance = null;
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Messages.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Messages instance = null;
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class Messages.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Messages instance = null;
        instance.storeMessage();
        fail("The test case is a prototype.");
    }
    
}
