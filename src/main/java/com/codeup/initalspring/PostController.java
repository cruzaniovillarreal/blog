package com.codeup.initalspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "This page will display all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
        return "This page will display an individual post with an ID of " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This page will display a form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost() {
        return "This will create the post";
    }
}
