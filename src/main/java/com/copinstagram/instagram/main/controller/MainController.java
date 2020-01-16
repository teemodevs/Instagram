package com.copinstagram.instagram.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hello","helloworld");
        return "index";
    }
}
