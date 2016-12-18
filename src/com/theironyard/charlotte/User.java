package com.theironyard.charlotte;

import org.eclipse.jetty.util.ConcurrentArrayQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by graceconnelly on 12/15/16.
 */
public class User {
    String name;
    List<String> messages;

    public User(String name, List<String> messages) throws Exception {
        if (name == null || "".equals(name)) {
           throw new IllegalArgumentException("This is not a valid name entry.");
        }
        else {
            this.name = name;
        }
        this.messages = messages;
    }
}

