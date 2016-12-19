package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    static User user;
    //static Message message;


    public static void main(String[] args) {
        // write your code here
        Spark.init();


        Spark.get("/", ((request, response) -> {
            //creating a HashMap to store a name and message
                    HashMap home = new HashMap();
                    if (user == null) {
                        return new ModelAndView(home, "index.html");
                    } else {
                        home.put("name", user.name);
                        home.put("messages", user.messages);
                        return new ModelAndView(home, "message.html");
                    }
                }),
                new MustacheTemplateEngine());


        Spark.post("/login",
                ((request, response) -> {
                    // we're getting the name from the form the user submitted
                    String name = request.queryParams("loginName");
                    //using that name to set the current user and the message
                    user = new User(name, null);
                    //go back to the homepage
                    response.redirect("/");
                    return "";
                })


        );

        Spark.post("/postMessage", (((request, response) -> {
            String message = request.queryParams("message");
            user.messages.add(message);
            response.redirect("/");
            return "";
        })));

    }


}



