package com.copinstagram.instagram.board.controller;

import com.copinstagram.instagram.board.error.BoardError;
import com.copinstagram.instagram.board.error.ErrorResponse;
import com.copinstagram.instagram.board.exception.NotFoundBoardException;
import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.entity.Board;
import com.copinstagram.instagram.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    @GetMapping("/board/{id}")
    public Board findById(@PathVariable("id")Long id){
        return boardService.findById(id);
    }

    @PostMapping("/board")
    public void save(@RequestBody BoardSaveRequestDto boardRequest){
        boardService.save(boardRequest);
    }

    @ExceptionHandler(NotFoundBoardException.class)
    public Object handleNotFoundBoardException(Throwable t) {
        return new ErrorResponse(BoardError.NOT_FOUND_BOARD);
    }
}
