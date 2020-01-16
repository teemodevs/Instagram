package com.copinstagram.instagram.board.repository;

import com.copinstagram.instagram.InstagramApplication;
import com.copinstagram.instagram.board.exception.NotFoundBoardException;
import com.copinstagram.instagram.board.model.entity.Board;
import com.copinstagram.instagram.board.repository.BoardRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//@DataJpaTest
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @AfterEach
    public void cleanup(){
        boardRepository.deleteAll();
    }
    @Test
    public void givenBoardEntityRepository_whenSaveAndRetreiveEntity_thenOK(){
        //given
        Board givenBoard = Board.builder()
                .content("content")
                .author("author")
                .build();
        //when
        Board thenBoard = boardRepository.save(givenBoard);
        Optional<Board> optReadBoard = boardRepository.findById(thenBoard.getId());
        Board readBoard = optReadBoard.orElseGet(()->Board.builder()
                .content("")
                .author("")
                .build());
        //then
        assertThat(readBoard.getAuthor(), is(givenBoard.getAuthor()));
        assertThat(thenBoard.getContent(), is(givenBoard.getContent()));
    }
    @Test
    public void givenIdIsNull_whenFindById_thenThrowIllegalArgumentException(){
        //given
        Long id = null;
        //when, then
        assertThrows(IllegalArgumentException.class, ()->boardRepository.findById(id));
    }

    @Test
    public void dontGivenDateTime_whenSaveAndRetreiveEntity_thenSaveDateTime(){
        //given
        LocalDateTime now = LocalDateTime.now();
        Board dontGivenDateTimeBoard = Board.builder()
                .content("content")
                .author("author")
                .build();
        Board thenBoard = boardRepository.save(dontGivenDateTimeBoard);
        //when
        Optional<Board> optReadBoard = boardRepository.findById(thenBoard.getId());
        Board readBoard = optReadBoard.orElseGet(()->Board.builder()
                .content("")
                .author("")
                .build());
        assertTrue(readBoard.getCreatedDate().isAfter(now));
        assertTrue(readBoard.getModifiedDate().isAfter(now));
    }
}
