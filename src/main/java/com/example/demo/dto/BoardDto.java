package com.example.demo.dto;

import com.example.demo.entity.Board;

public class BoardDto {
    public final Integer id;
    public final String title;
    public final String content;

    public BoardDto(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static BoardDto from(Board board) {
        return new BoardDto(board.getId(), board.getTitle(), board.getContent());
    }
}
