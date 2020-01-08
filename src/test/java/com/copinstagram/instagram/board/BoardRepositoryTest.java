package com.copinstagram.instagram.board;

import com.copinstagram.instagram.board.model.entity.Board;
import com.copinstagram.instagram.board.repository.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @AfterEach
    public void cleanup(){
        boardRepository.deleteAll();
    }
    @Test
    public void whenSaveBoard_thenReadBoard(){
        //given
        boardRepository.save(Board.builder()
                .content("hello world")
                .author("jdk")
                .build()
        );
        //when
        List<Board> boardList =  boardRepository.findAll();
        //then
        Board board = boardList.get(0);
        assertThat(board.getAuthor(), is("jdk"));
        assertThat(board.getContent(), is("hello world"));
    }
}
