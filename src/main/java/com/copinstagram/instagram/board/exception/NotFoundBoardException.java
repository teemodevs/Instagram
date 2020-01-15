package com.copinstagram.instagram.board.exception;

public class NotFoundBoardException extends RuntimeException{
    public NotFoundBoardException(){
        super();
    }
    public NotFoundBoardException(String message){
        super(message);
    }
    public NotFoundBoardException(String message, Throwable t){
        super(message, t);
    }
}
