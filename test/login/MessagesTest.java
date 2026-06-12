package login;

import org.junit.Test;           
import static org.junit.Assert.*;

public class MessagesTest {

    @Test
    public void testMessageUnder250Characters() {

        Messages msg = new Messages(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertEquals(
                "Message ready to send.",
                msg.checkMessages()
        );
    }

    @Test
    public void testMessageOver250Characters() {

        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaa";

        Messages msg = new Messages("+27718693002", longMessage);

        assertTrue(
                msg.checkMessages().contains("Message exceeds 250 characters")
        );
    }

    @Test
    public void testValidRecipientNumber() {

        Messages msg = new Messages(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testInvalidRecipientNumber() {

        Messages msg = new Messages(
                "08575975889",
                "Hi Keegan, did you receive the payment?");

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testMessageIDLength() {

        Messages msg = new Messages(
                "+27718693002",
                "Hello");

        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testGenerateMessageID() {

        Messages msg = new Messages(
                "+27718693002",
                "Hello");

        String id = msg.generateMessageID();

        assertNotNull(id);
        assertEquals(10, id.length());
    }

    @Test
    public void testMessageHashCreated() {

        Messages msg = new Messages(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        String hash = msg.createMessageHash();

        assertNotNull(hash);
        assertTrue(hash.contains("HI"));
        assertTrue(hash.contains("TONIGHT"));
    }

    @Test
    public void testPrintMessages() {

        Messages msg = new Messages(
                "+27718693002",
                "Hello");

        assertNotNull(msg.printMessages());
    }

    @Test
    public void testReturnTotalMessages() {

        Messages msg = new Messages(
                "+27718693002",
                "Hello");

        assertEquals(0, msg.returnTotalMessages());
    }

    @Test
public void testStoreMessage() {
    Messages msg = new Messages("+27718693002", "Hello");
    msg.storeMessage();
}
}