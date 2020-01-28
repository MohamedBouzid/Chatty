package chatty.common;

import chatty.client.User;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Conversation {

    private String conversationId;
    private List<Pair<User, Message>> conversation;

    public Conversation() {
        conversation = new ArrayList<Pair<User, Message>>();
    }

    public Message getMessageAt(int i) {
        return conversation.get(i).getValue();
    }

    public boolean addMessage(Pair<User, Message> userMessagePair) {
        return conversation.add(userMessagePair);
    }
}
