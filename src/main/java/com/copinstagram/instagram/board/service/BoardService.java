package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.entity.Board;

public interface BoardService {
    public void save(BoardSaveRequestDto boardRequest);
    public Board findById(Long id);
}
