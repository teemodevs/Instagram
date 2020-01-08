package com.copinstagram.instagram.board.controller;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @PostMapping("/board")
    public void saveBoard(@RequestBody BoardSaveRequestDto boardRequest){
        boardService.save(boardRequest);
    }
}
