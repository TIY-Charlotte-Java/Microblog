package com.theironyard.charlotte;

import java.util.ArrayList;


public class User {
    String name;
    ArrayList<String> storeMessage = new ArrayList<>();

    public User(String name, ArrayList storeMessage) {
        this.name = name;
        this.storeMessage = new ArrayList<>();
    }
}
