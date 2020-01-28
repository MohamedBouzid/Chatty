package chatty.common;

import java.util.Date;

public class Message {
    private static final int CAPACITY = 256;
    private String text;
    private int size;
    private Date date;

    public Message(String text) {
        this.text = text;
        this.date = new Date(System.currentTimeMillis());
        this.size = text.length();
        assert (this.size <= CAPACITY);
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int compareText(String testMessage) {
        return this.text.compareTo(testMessage);
    }
}
