package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardsMainResponseDto;
import com.copinstagram.instagram.board.model.entity.Board;

import java.util.List;

public interface BoardService {
    public List<BoardsMainResponseDto> findAllDesc();
    public Long save(BoardSaveRequestDto boardSaveRequestDto);
    public Board findById(Long id);
    public void update(Long id, BoardUpdateRequestDto boardUpdate);
    public void deleteById(Long id);
}
