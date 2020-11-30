package com.codeup.initalspring.controllers;

import models.Post;
import models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("1st Post", "Body of first post"));
        posts.add(new Post("2nd Post", "Body of second post"));
        posts.add(new Post("3rd Post", "Body of third post"));
        model.addAttribute("posts", posts);

        return "templates/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
        Post post = new Post("Individual Post", "This is the body of the individual post");
        model.addAttribute("post", post);
        return "templates/posts/show";
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

    @PostMapping("/posts/update")
    @ResponseBody
    public String updatePost() {
        return "This will create the post";
    }

    @PostMapping("/posts/delete")
    @ResponseBody
    public String deletePost() {
        return "This will create the post";
    }
}
