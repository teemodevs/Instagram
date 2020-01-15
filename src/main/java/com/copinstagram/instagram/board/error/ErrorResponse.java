package com.copinstagram.instagram.board.error;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private int code;
    private String description;

    public ErrorResponse(BoardError boardError){
        this.code = boardError.getCode();
        this.description = boardError.getDescription();
    }
}
