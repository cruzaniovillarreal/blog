package com.codeup.initalspring.controllers;

import com.codeup.initalspring.models.Post;
import com.codeup.initalspring.models.PostRepository;
import com.codeup.initalspring.models.User;
import com.codeup.initalspring.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "templates/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
        User user = userDao.getOne(1L);
        Post post = new Post( "Individual Post", "This is the body of the individual post", user);
        model.addAttribute("post", post);
        return "templates/posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "templates/posts/new";
    }

    @PostMapping("/posts/create")
    public String submitPost(@RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String desc) {
        User user = userDao.getOne(1L);
        Post createdPost = new Post(title, desc, user);
        Post dbPost = postDao.save(createdPost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/update")
    @ResponseBody
    public String updatePost() {
        return "This will update the post";
    }

    @PostMapping("/posts/delete")
    @ResponseBody
    public String deletePost() {
        postDao.deleteById((long) 2);
        return "This will delete the post";
    }
}
