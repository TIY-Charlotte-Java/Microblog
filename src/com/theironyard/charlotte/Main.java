package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static User user;
    static ArrayList<String> comments = new ArrayList();

    public static void main(String[] args) {

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap< String, String> m = new HashMap();
                    if (user == null) {
                        return new ModelAndView(m, "index.html");
                    } else {
                        m.put("name", user.name);
                        return new ModelAndView(m, "messages.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-user",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";
                })
        );

        Spark.post(
                "/create-comment",
                ((request, response) -> {
                    String comment = request.queryParams("messages");
                    comments.add(comment);
                    response.redirect("/");
                    return new ModelAndView(comment, "messages.html");
                }),
                new MustacheTemplateEngine()
        );
    }
}
