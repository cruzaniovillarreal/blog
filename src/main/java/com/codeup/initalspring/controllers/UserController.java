package com.codeup.initalspring.controllers;

import com.codeup.initalspring.models.User;
import com.codeup.initalspring.repositories.PostRepository;
import com.codeup.initalspring.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;
    private PostRepository postDao;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder, PostRepository postDao) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.postDao = postDao;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        model.addAttribute("posts", postDao.findPostsByOwnerEquals((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
            return "users/profile";
    }
}