package com.copinstagram.instagram.board.error;

public enum BoardError {
    NOT_FOUND_BOARD(1000, "Not found board");

    private int code;
    private String description;
    private BoardError(int code, String description){
        this.code = code;
        this.description = description;
    }
    public int getCode(){
        return this.code;
    }
    public String getDescription(){
        return this.description;
    }
}
