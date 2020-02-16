package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardsGetResponseDto;
import com.copinstagram.instagram.board.model.entity.Board;

import java.util.List;

public interface BoardService {
    public List<BoardsGetResponseDto> findAllDesc();
    public List<BoardsGetResponseDto> findByAuthorOrderByCreatedDateDesc(String author);
    public Long save(BoardSaveRequestDto boardSaveRequestDto);
    public BoardsGetResponseDto findById(Long id);
    public void update(Long id, BoardUpdateRequestDto boardUpdate);
    public void deleteById(Long id);
}
