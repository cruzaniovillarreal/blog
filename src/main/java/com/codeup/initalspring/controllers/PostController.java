package com.codeup.initalspring.controllers;

import com.codeup.initalspring.models.*;
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
    private final ImageRepository imageDao;

    public PostController(PostRepository postDao, UserRepository userDao, ImageRepository imageDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/")
    public String individualPost(@RequestParam(name = "id") int id, Model model) {
        Post post = postDao.getOne((long) id);
        model.addAttribute("post", post);
        model.addAttribute("images", post.getImages());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String submitPost(@RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String desc) {
        User user = userDao.getOne(1L);
        Post createdPost = new Post(title, desc, user);
        PostImage imageOne = new PostImage("https://images.pexels.com/photos/346885/pexels-photo-346885.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", createdPost);
        PostImage imageTwo = new PostImage("https://static.toiimg.com/photo/msid-75141327,width-96,height-65.cms", createdPost);
        PostImage imageThree = new PostImage("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2020%2F01%2Fhawaii-december-EVRYMONTH1019.jpg&q=85", createdPost);
        Post dbPost = postDao.save(createdPost);
        PostImage dbImageOne = imageDao.save(imageOne);
        PostImage dbImageTwo = imageDao.save(imageTwo);
        PostImage dbImageThree = imageDao.save(imageThree);

        return "redirect:/posts";
    }

    @PostMapping("/posts/update")
    public String updatePost(@RequestParam(name = "id") long id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String desc) {
        Post updatedPost = postDao.getOne(id);
        updatedPost.setTitle(title);
        updatedPost.setBody(desc);
        Post dbPost = postDao.save(updatedPost);
        return "redirect:/posts/?id="+id;
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "id") int id) {
        postDao.deleteById((long) id);
        return "redirect:/posts";
    }
}
