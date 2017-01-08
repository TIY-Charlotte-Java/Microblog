package com.theironyard.charlotte;


import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static User user;


    public static void main(String[] args) {
        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap<String, Object> m = new HashMap<>();
                    if (user == null) {
                        return new ModelAndView(m, "index.html");
                    }
                    else{
                        m.put("name", user.name);
                        m.put("messages",user.storeMessage);
                        return new ModelAndView(m, "messages.html");
                    }
                }),
                new MustacheTemplateEngine()
        );
        Spark.post(
                "/create-user",
                ((request, response) -> {
                    String name = request.queryParams("userName");
                    ArrayList<String> messages = new ArrayList<String>();
                    user = new User(name,messages);

                    response.redirect("/");
                    return "";
                })
        );
        Spark.post(
                "/create-message",
                ((request, response) -> {
                    String message = request.queryParams("message");
                    if (message == null || "".equals(message)){
                    }
                    else {
                        user.storeMessage.add(message);
                    }
                    response.redirect("/");
                    return "";
                })
        );
    }
}