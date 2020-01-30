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
        System.err.println("hello world 1111111111111111111111111111111");
        System.err.println(boardService.findAllDesc());
        model.addAttribute("boards", boardService.findAllDesc());
        return "index";
    }
}
