package login;
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTestPart3 {

    // Populates a Messages object with the 5 test messages from the brief
    private Messages createTestMessages() {
        Messages msg = new Messages("", "");
        msg.addTestMessage("+27834557896", "Did you get the cake?", "Sent");
        msg.addTestMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        msg.addTestMessage("+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        msg.addTestMessage("0838884567", "It is dinner time!", "Sent");
        msg.addTestMessage("+27838884567", "Ok, I am leaving without you.", "Stored");
        return msg;
    }

    // Tests sent messages array is correctly populated
    @Test
    public void testSentMessagesPopulated() {
        Messages msg = createTestMessages();
        assertTrue(msg.sentMessages.contains("Did you get the cake?"));
        assertTrue(msg.sentMessages.contains("It is dinner time!"));
    }

    // Tests that the longest message is correctly identified
    @Test
    public void testLongestMessage() {
        Messages msg = createTestMessages();
        assertEquals("Where are you? You are late! I have asked you to be on time.", msg.getLongestMessage());
    }

    // Tests search by message ID returns correct message
    @Test
    public void testSearchMessageID() {
        Messages msg = createTestMessages();
        String result = msg.searchMessageID(msg.messageIDs.get(3));
        assertTrue(result.contains("It is dinner time!"));
    }

    // Tests search by recipient returns all matching messages
    @Test
    public void testSearchRecipientMessages() {
        Messages msg = createTestMessages();
        String result = msg.searchRecipientMessages("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    // Tests that a message is successfully deleted using its hash
    @Test
    public void testDeleteMessage() {
        Messages msg = createTestMessages();
        String hash = msg.messageHash.get(1);
        String result = msg.deleteMessage(hash);
        assertTrue(result.contains("successfully deleted"));
    }

    // Tests that the report displays all message details
    @Test
    public void testDisplayReport() {
        Messages msg = createTestMessages();
        String result = msg.displayReport();
        assertNotNull(result);
        assertTrue(result.contains("Did you get the cake?"));
    }
}