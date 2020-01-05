package com.copinstagram.instagram.board.domain.dto;

import com.copinstagram.instagram.board.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String content;
    private String author;

    public Board toEntity(){
        return Board.builder()
                .content(content)
                .author(author)
                .build();
    }
}
