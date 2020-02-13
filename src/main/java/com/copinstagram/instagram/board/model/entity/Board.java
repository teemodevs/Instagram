package com.copinstagram.instagram.board.model.entity;

import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Board extends BaseTimeEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Board(String content, String author){
        this.content = content;
        this.author = author;
    }
    /**
     * description : jpa 업데이트를 위한 메서드로 setter 대신 사용한다.
     * @param dto
     * @return
     */
    public Board updateMyAccount(BoardUpdateRequestDto dto) {
        this.content = dto.getContent();
        this.author = dto.getAuthor();
        return this;
    }
}
