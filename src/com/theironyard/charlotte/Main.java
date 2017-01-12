package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static User user;
    static Message message;

    public static void main(String[] args) {
        ArrayList<Message> t = new ArrayList<>();
        //HashMap<String, String> m = new HashMap<>();
        HashMap<String, ArrayList<Message>> me = new HashMap<>();
        Spark.get(
                "/",
                ((request, response) -> {

                    if (user == null) {
                        return new ModelAndView(me, "index.html");
                    } else {
                        me.put(user.name, t);
                        return new ModelAndView(me, "messages.html");
                    }
                }),
                new MustacheTemplateEngine()
        );
        Spark.post(
                "/create-user",
                (request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";
                }
        );
        Spark.post(
                "/create-message",
                (request, response) -> {
                    String text = request.queryParams("message");
                    message = new Message(text);
                    t.add(message);
                    System.out.println(t);
                    response.redirect("/");
                    return "";
                }
        );
    }
}
