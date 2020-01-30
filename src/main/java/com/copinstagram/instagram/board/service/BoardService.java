package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardsMainResponseDto;
import com.copinstagram.instagram.board.model.entity.Board;

import java.util.List;

public interface BoardService {
    public List<BoardsMainResponseDto> findAllDesc();
    public Long save(BoardSaveRequestDto boardRequest);
    public Board findById(Long id);
}
