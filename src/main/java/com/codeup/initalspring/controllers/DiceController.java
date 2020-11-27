package com.codeup.initalspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.model.IModel;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dicePage() {
        return "templates/dice/dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String getNumber(@PathVariable int num, Model model) {
        int roll = (int) ((Math.random() * (6 - 1)) + 1);
        model.addAttribute("guess", num);
        model.addAttribute("roll", roll);
        if (roll == num) {
            model.addAttribute("match", true);
        } else {
            model.addAttribute("match", false);
        }
        return "templates/dice/dice";
    }
}
