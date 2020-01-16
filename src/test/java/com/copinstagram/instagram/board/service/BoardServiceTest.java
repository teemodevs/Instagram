package com.copinstagram.instagram.board.service;

import com.copinstagram.instagram.board.model.dto.BoardSaveRequestDto;
import com.copinstagram.instagram.board.model.entity.Board;
import com.copinstagram.instagram.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void givenBoardDto_whenSave_thenOk(){
        //given
        BoardSaveRequestDto boardSaveDto = BoardSaveRequestDto.builder()
                .content("myContent")
                .author("myAuthor")
                .build();
        //when
        Long id = boardService.save(boardSaveDto);
        //then
        Optional<Board> optReadBoard = boardRepository.findById(id);
        Board readBoard = optReadBoard.orElseGet(()->Board.builder()
                .content("")
                .author("")
                .build());
        //then
        assertThat(readBoard.getAuthor(), is(boardSaveDto.getAuthor()));
        assertThat(readBoard.getContent(), is(boardSaveDto.getContent()));
    }
}
