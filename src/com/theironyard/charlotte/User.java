package com.theironyard.charlotte;

import java.util.ArrayList;

/**
 * Created by emileenmarianayagam on 12/15/16.
 */
public class User {

    String name;
    ArrayList<String> messages;

    public User(String name, ArrayList<String> messages) {
        this.name = name;
        this.messages = new ArrayList<>();
    }


}
