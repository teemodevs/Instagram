package com.copinstagram.instagram.main.controller;

import com.copinstagram.instagram.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    private BoardService boardService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("boards", boardService.findAllDesc());
        return "index";
    }
}