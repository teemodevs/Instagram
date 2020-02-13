package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.exception.NotFoundBoardException;
import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardsMainResponseDto;
import com.copinstagram.instagram.board.model.entity.Board;
import com.copinstagram.instagram.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    private BoardRepository boardRepository;
    @Transactional
    @Override
    public Long save(BoardSaveRequestDto boardSaveRequestDto) {
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(NotFoundBoardException::new);
    }

    @Transactional(readOnly = true)
    public List<BoardsMainResponseDto> findAllDesc(){
        return boardRepository.findAllDesc()
                .map(BoardsMainResponseDto::new)
                .collect(Collectors.toList());
    }
    public void update(Long id, BoardUpdateRequestDto boardUpdate){
        Board board = boardRepository.findById(id).orElseThrow(NotFoundBoardException::new);
        board.updateMyAccount(boardUpdate);
    }
    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }
}
