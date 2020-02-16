package com.copinstagram.instagram.board.controller;

import com.copinstagram.instagram.board.error.BoardError;
import com.copinstagram.instagram.board.error.ErrorResponse;
import com.copinstagram.instagram.board.exception.NotFoundBoardException;
import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardsGetResponseDto;
import com.copinstagram.instagram.board.model.entity.Board;
import com.copinstagram.instagram.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    @GetMapping("/boards/{id}")
    public BoardsGetResponseDto findById(@PathVariable("id")Long id){
        return boardService.findById(id);
    }

    @PostMapping("/boards")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return boardService.save(boardSaveRequestDto);
    }
    @GetMapping("/boards")
    public List<BoardsGetResponseDto> findByAuthorOrderByCreatedDateDesc(){
        return boardService.findByAuthorOrderByCreatedDateDesc("test1@gmail.com");
    }
    @PutMapping("/boards/{id}")
    public void update(@PathVariable("id")Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        boardService.update(id, boardUpdateRequestDto);
    }
    @DeleteMapping("/boards/{id}")
    public void delete(@PathVariable("id")Long id){
        boardService.deleteById(id);
    }

    @ExceptionHandler(NotFoundBoardException.class)
    public Object handleNotFoundBoardException(Throwable t) {
        return new ErrorResponse(BoardError.NOT_FOUND_BOARD);
    }
}
