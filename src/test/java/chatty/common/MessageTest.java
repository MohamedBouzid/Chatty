package chatty.common;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {
    Message message = new Message("Smoke Test message");

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getDate() {
    }

    @org.junit.jupiter.api.Test
    void setDate() {
    }

    @Test
    void getSize() {
        assertEquals(message.getSize(), 18);
    }
}
