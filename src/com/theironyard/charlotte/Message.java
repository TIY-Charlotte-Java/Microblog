package com.theironyard.charlotte;

import spark.Spark;

/**
 * Created by emileenmarianayagam on 12/15/16.
 */
public class Message {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;


    public Message(String message) {
        this.message = message;
    }



}
