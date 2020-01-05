package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.domain.Board;
import com.copinstagram.instagram.board.domain.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    private BoardRepository boardRepository;
    @Override
    public void save(BoardSaveRequestDto boardRequest) {
        boardRepository.save(boardRequest.toEntity());
    }
}
