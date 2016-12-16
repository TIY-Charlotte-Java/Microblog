package com.theironyard.charlotte;

import java.util.List;

/**
 * Created by temp on 12/16/16.
 */
public class User {
    String name;
    List<String> currentMessage;

    public User(String name, List<String> currentMessage) {
        this.name = name;
        this.currentMessage = currentMessage;
    }
}
