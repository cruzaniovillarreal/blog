package com.codeup.initalspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num}/and/{num2}")
    @ResponseBody
    public int addition(@PathVariable int num, @PathVariable int num2) {
        return num+num2;
    };

    @GetMapping("/subtract/{num}/from/{num2}")
    @ResponseBody
    public int subtraction(@PathVariable int num, @PathVariable int num2) {
        return num-num2;
    };

    @GetMapping("/multiply/{num}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num, @PathVariable int num2) {
        return num*num2;
    };

    @GetMapping("/divide/{num}/by/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num, @PathVariable int num2) {
        return num/num2;
    };


}
