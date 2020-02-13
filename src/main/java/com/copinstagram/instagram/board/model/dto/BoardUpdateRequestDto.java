package com.copinstagram.instagram.board.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String content;
    private String author;

    @Builder
    public BoardUpdateRequestDto(String content, String author){
        this.content = content;
        this.author = author;
    }
}
