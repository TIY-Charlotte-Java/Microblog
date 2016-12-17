package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static User user;


    public static void main(String[] args) {
        // write your code here
        Spark.init();


        Spark.get("/", ((request, response) -> {
                    HashMap<String, String> home = new HashMap();
                    if (user == null) {
                        return new ModelAndView(home, "index.html");
                    } else {
                        home.put("name", user.name);
                        return new ModelAndView(home, "message.html");

                    }

                }),
                new MustacheTemplateEngine());


        Spark.get("/postMessage", (((request, response) -> {
            HashMap<String, ArrayList<String>> messageStore = new HashMap<>();

            if (user.message == null) {
                return new ModelAndView(messageStore, "message.html");
            } else {
                messageStore.put("message", user.message);
                return new ModelAndView(messageStore, "message.html");


            }

        })), new MustacheTemplateEngine());


        Spark.post("/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";

                })


        );

        Spark.post("/postMessage", (((request, response) -> {
            String message = request.queryParams("Message");
            user = new User(message);
            response.redirect("/postMessage");
            return "";
        })));

    }


}



