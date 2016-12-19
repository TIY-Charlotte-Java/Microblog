package com.theironyard.charlotte;

import java.util.ArrayList;

/**
 * Created by emileenmarianayagam on 12/15/16.
 */
public class User {
<<<<<<< HEAD
=======
    String name;
    ArrayList<String> message;


>>>>>>> 8c2c49a516e34017df49264e3e7408e76785fc4f

    public User(String name, ArrayList<String> messages) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.message = new ArrayList<>();
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    String name;
    ArrayList<String> messages;




}
