package chatty.client;

import chatty.common.Conversation;
import chatty.common.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void sendAMessage() {
        String testMessage = "hello user2 !";
        user1.connect();
        try {
            user1.sendAMessage(user2, testMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Conversation conversation = user1.getUserConversation(user2);
        Message message = conversation.getMessageAt(0);
        assertEquals(message.compareText(testMessage), 0);
    }

    @Test
    void openConversation() {
    }

    @Test
    void openConversations() {
    }

    @Test
    void connect() {
    }

    @Test
    void disconnect() {
    }
}