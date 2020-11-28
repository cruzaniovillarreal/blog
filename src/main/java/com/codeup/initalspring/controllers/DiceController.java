package com.codeup.initalspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dicePage() {
        return "templates/dice/dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String getNumber(@PathVariable int num, Model model) {
        List<Integer> dice = new ArrayList<>();
        for (int i = 6; i > 0; i--) {
            int roll = (int) ((Math.random() * (7 - 1)) + 1);
            dice.add(roll);
        }
        model.addAttribute("guess", num);
        model.addAttribute("dice", dice);

        int roll = (int) ((Math.random() * (7 - 1)) + 1);
        if (roll == num) {
            model.addAttribute("match", true);
        } else {
            model.addAttribute("match", false);
        }
        model.addAttribute("roll", roll);

        int count = 0;
        for(int die : dice) {
            if (die == num) {
                count += 1;
            }
        }

        model.addAttribute("correct", count);

        return "templates/dice/dice";
    }
}
