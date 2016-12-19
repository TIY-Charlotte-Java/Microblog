package com.theironyard.charlotte;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Objects;

public class Main {
    static User user;
    //static Message message;
=======
import java.util.List;

public class Main {
    static User user;
>>>>>>> 8c2c49a516e34017df49264e3e7408e76785fc4f


    public static void main(String[] args) {
        // write your code here
        Spark.init();


        Spark.get("/", ((request, response) -> {
<<<<<<< HEAD
            //creating a HashMap to store a name and message

                    HashMap home = new HashMap();
=======
                    HashMap<String, String> home = new HashMap();
>>>>>>> 8c2c49a516e34017df49264e3e7408e76785fc4f
                    if (user == null) {
                        return new ModelAndView(home, "index.html");
                    } else {
                        // putting the key and the message
                        home.put("name", user.name);
<<<<<<< HEAD
                        home.put("messages", user.messages);
                        return new ModelAndView(home, "message.html");
=======
                        return new ModelAndView(home, "message.html");

>>>>>>> 8c2c49a516e34017df49264e3e7408e76785fc4f
                    }
                }),
                //takes the elements out of the post and displays
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
<<<<<<< HEAD
            String message = request.queryParams("message");
            user.messages.add(message);
            response.redirect("/");
=======
            String message = request.queryParams("Message");
            user = new User(message);
            response.redirect("/postMessage");
>>>>>>> 8c2c49a516e34017df49264e3e7408e76785fc4f
            return "";
        })));

    }


}



