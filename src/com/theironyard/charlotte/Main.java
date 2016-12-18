package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

public class Main {
    public static User user;

    public static void main(String[] args) {
        Spark.get("/",
                ((request, response) -> {
                    HashMap<String, Object> userNames = new HashMap<>();
                 if (user == null) {
                     return new ModelAndView(userNames, "index.html");
                 } else {
                     userNames.put("name" , user.name);
                     userNames.put("message", user.storeMessage);
                     return new ModelAndView(userNames, "messages.html");
                 }
                }),
                new MustacheTemplateEngine()
        );
        Spark.post("/create-user",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name, null);
                    response.redirect("/");
                    return "";
                })
                );
        Spark.post("/create-message",
                (request, response) -> {
                    String message = request.queryParams("message");
                    user.storeMessage.add(message);
                    response.redirect("/");
                    return "";
                }
        );
    }
}
