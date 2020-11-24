package com.codeup.initalspring.controllers;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("1st Post", "Body of first post"));
        posts.add(new Post("2nd Post", "Body of second post"));
        posts.add(new Post("3rd Post", "Body of third post"));
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
        Post post = new Post("Individual Post", "This is the body of the individual post");
        model.addAttribute("post", post);
        return "/posts/show";
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
