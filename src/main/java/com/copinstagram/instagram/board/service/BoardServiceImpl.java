package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    private BoardRepository boardRepository;
    @Override
    public void save(BoardSaveRequestDto boardRequest) {
        boardRepository.save(boardRequest.toEntity());
    }
}
