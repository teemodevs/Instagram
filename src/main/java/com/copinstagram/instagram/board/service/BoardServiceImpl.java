package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.exception.NotFoundBoardException;
import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import com.copinstagram.instagram.board.model.dto.BoardsGetResponseDto;
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
    public BoardsGetResponseDto findById(Long id) {
        return new BoardsGetResponseDto(boardRepository.findById(id).orElseThrow(NotFoundBoardException::new));
    }

    /**
     * findAll은 일단 보류.
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<BoardsGetResponseDto> findAllDesc(){
        return boardRepository.findAllDesc()
                .map(BoardsGetResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    @Override
    public List<BoardsGetResponseDto> findByAuthorOrderByCreatedDateDesc(String author){
        return boardRepository.findByAuthorOrderByCreatedDateDesc(author)
                .map(BoardsGetResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    @Override
    public void update(Long id, BoardUpdateRequestDto boardUpdate){
        Board board = boardRepository.findById(id).orElseThrow(NotFoundBoardException::new);
        board.updateMyAccount(boardUpdate);
    }
    @Transactional
    @Override
    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }
}
