package com.example.gg4ndBe.domain.board.dto;

import com.example.gg4ndBe.domain.board.model.Board;
import lombok.Builder;

public class BoardDto {
    public record GetBoardDetailResDto(
            Long id,
            String title,
            String content,
            String createdAt,
            String modifiedAt
    ) {
        @Builder
        public GetBoardDetailResDto {
        }

        public static GetBoardDetailResDto of(Board board) {
            return GetBoardDetailResDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdAt(board.getCreatedAt())
                    .modifiedAt(board.getModifiedAt())
                    .build();
        }
    }

    public record GetBoardListResDto(
            Long id,
            String title,
            String createdAt
    ) {
        @Builder
        public GetBoardListResDto {
        }

        public static GetBoardListResDto of(Board board) {
            return GetBoardListResDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .createdAt(board.getCreatedAt())
                    .build();
        }
    }

    public record SaveBoardReqDto(
            String title,
            String content
    ) {
        @Builder
        public SaveBoardReqDto {
        }

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
