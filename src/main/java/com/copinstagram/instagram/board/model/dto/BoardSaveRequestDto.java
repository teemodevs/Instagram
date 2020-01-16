package com.copinstagram.instagram.board.model.dto;

import com.copinstagram.instagram.board.model.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String content;
    private String author;

    @Builder
    public BoardSaveRequestDto(String content, String author){
        this.content = content;
        this.author = author;
    }
    public Board toEntity(){
        return Board.builder()
                .content(content)
                .author(author)
                .build();
    }
}
