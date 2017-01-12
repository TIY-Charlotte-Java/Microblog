package com.theironyard.charlotte;

/**
 * Created by Ben on 12/16/16.
 */
public class Message {
    String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
