package chatty.client;

import chatty.common.Conversation;
import chatty.common.Message;
import javafx.util.Pair;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class User implements Comparable {
    private String userId;

    private String pseudo;
    private String userEmail;
    private Status status;
    private Map<User, Conversation> conversationPerUser;

    public User(String pseudo, String userEmail) {
        this.pseudo = pseudo;
        this.userEmail = userEmail;
        this.status = Status.ONLINE;
        this.conversationPerUser = new TreeMap<User, Conversation>();
    }

    public Map<User, Conversation> getConversationPerUser() {
        return conversationPerUser;
    }

    public void updateConversationWithUser(User user, Conversation conversation) {
        this.conversationPerUser.put(user, conversation);
    }

    Conversation getUserConversation(User user) {
        return this.conversationPerUser.get(user);
    }

    void sendAMessage(User destination, String text) throws Exception {
        if (status == Status.ONLINE) {
            Message message = new Message(text);
            Conversation conversation = this.conversationPerUser.get(destination);
            boolean isAdded = false;
            if (conversation == null) {
                conversation = new Conversation();
                conversationPerUser.put(destination, conversation);
            }
            isAdded = conversation.addMessage(new Pair<User, Message>(destination, message));
            destination.updateConversationWithUser(this, conversation);
            if (!isAdded) {
                throw new Exception("ERROR : Message not sent");
            }
        } else {
            throw new Exception("ERROR : User is offline");
        }
    }

    void openConversation(User user) {

    }

    void openConversations() {

    }

    void connect() {
        this.status = Status.ONLINE;
    }

    void disconnect() {
        this.status = Status.OFFLINE;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", conversationPerUser=" + conversationPerUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(pseudo, user.pseudo) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(conversationPerUser, user.conversationPerUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, pseudo, userEmail, conversationPerUser);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(Object o) {
        User compareTo = (User) o;
        return pseudo.compareTo((compareTo.pseudo));
    }

    public enum Status {
        ONLINE,
        OFFLINE
    }
}
