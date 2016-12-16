package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static User user;
    static Message message;

    public static void main(String[] args) {
        // write your code here
        Spark.init();

        Spark.get("/", ((request, response) -> {
                    HashMap<String, String> home = new HashMap();
                    ArrayList<Message> message = new ArrayList<Message>();

                    if (user == null) {
                        return new ModelAndView(home, "index.html");
                    } else {
                        home.put("name", user.name);
                        return new ModelAndView(message, "message.html");
                        message.add(0,message.set());
                    }

                }),
                new MustacheTemplateEngine());


        Spark.post("/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";

                })

        );

    }



}



