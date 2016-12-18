package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.*;

public class Main {
    static User user;
    static String errorMsg;


    public static void main(String[] args) {
        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap<String, Object> m = new HashMap<>();
                    if (user == null) {
                        m.put("errorMsg",errorMsg);
                        return new ModelAndView(m, "index.html");
                    }
                    else{
                        m.put("name", user.name);
                        m.put("messages",user.messages);
                        return new ModelAndView(m, "messages.html");

                    }
                }),
                new MustacheTemplateEngine()
        );
        Spark.post(
                "/create-user",
                ((request, response) -> {
                    try {
                        String name = request.queryParams("userName");
                        List<String> messages = Collections.synchronizedList(new ArrayList<String>());
                        user = new User(name,messages);
                    }catch (IllegalArgumentException iae){
                        errorMsg = iae.getMessage();
                    }

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
                        user.messages.add(message);
                    }
                    response.redirect("/");
                    return "";
                })
        );


    }
}
