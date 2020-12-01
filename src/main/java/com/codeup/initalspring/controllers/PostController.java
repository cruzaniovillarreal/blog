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

    @GetMapping("/posts/")
    public String individualPost(@RequestParam(name = "id") int id, Model model) {
        Post post = postDao.getOne((long) id);
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
    public String updatePost(@RequestParam(name = "id") long id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String desc) {
        User user = userDao.getOne(1L);
        Post updatedPost = new Post(id, title, desc, user);
        Post dbPost = postDao.save(updatedPost);
        return "redirect:/posts/?id="+id;
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "id") int id) {
        postDao.deleteById((long) id);
        return "redirect:/posts";
    }
}
