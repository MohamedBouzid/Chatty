package chatty.client;

import chatty.common.Conversation;
import chatty.common.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user1, user2, user3;

    @BeforeEach
    void setUp() {
        user1 = new User("user1", "user1@yahoo.com");
        user2 = new User("user2", "user2@yahoo.com");
        user3 = new User("user3", "user3@yahoo.com");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void user1sendAMessageToUser2() {
        String testMessage = "hello user2 !";
        user1.connect();
        try {
            user1.sendAMessage(user2, testMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Conversation conversation12 = user1.getUserConversation(user2);
        Message message12 = conversation12.getMessageAt(0);
        assertEquals(message12.compareText(testMessage), 0);
        Conversation conversation21 = user2.getUserConversation(user1);
        assertNotNull(conversation21);
        Message message21 = conversation21.getMessageAt(0);
        assertEquals(message21.compareText(testMessage), 0);
    }

    @Test
    void openConversation() {
        Conversation conversation = user1.getUserConversation(user2);
        assertNull(conversation);
        conversation = user1.openConversation(user2);
        assertNotNull(conversation);
    }

    @Test
    void connect() {
    }

    @Test
    void disconnect() {
    }

    @Test
    void deleteConversationWithUser() {
        int size = user1.getConversationsSize();
        assertEquals(size, 0);
        try {
            user1.sendAMessage(user2, "Hello user2 !");
            user2.sendAMessage(user1, "Hello user1 !");
            user1.sendAMessage(user2, "What's up ?");
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = user1.getConversationsSize();
        assertEquals(size, 1);
        try {
            user1.sendAMessage(user3, "Hello user3 !");
        } catch (Exception e) {
            e.printStackTrace();
        }
        size = user1.getConversationsSize();
        assertEquals(size, 2);

    }
}