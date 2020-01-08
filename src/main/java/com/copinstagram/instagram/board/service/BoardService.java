package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;

public interface BoardService {
    public void save(BoardSaveRequestDto boardRequest);
}
