package com.example.gg4ndBe.domain.board.service;

import com.example.gg4ndBe.common.dto.PageResponse;
import com.example.gg4ndBe.domain.board.dto.BoardDto.*;
import com.example.gg4ndBe.domain.board.model.Board;
import com.example.gg4ndBe.domain.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import static com.example.gg4ndBe.common.constant.GlobalConstants.NOT_FOUND_BOARD;
import static com.example.gg4ndBe.common.constant.GlobalConstants.SUCCESS_MESSAGE;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public String addBoard(SaveBoardReqDto saveBoardReqDto) {
        boardRepository.save(saveBoardReqDto.toEntity());
        return SUCCESS_MESSAGE;
    }

    public GetBoardDetailResDto getBoardDetail(Long boardId) {
         return GetBoardDetailResDto.of(findBoard(boardId));
    }

    public PageResponse<GetBoardListResDto> getBoardList(Pageable pageable) {
        return PageResponse.of(boardRepository.findAllByIsVisible(pageable, true).map(GetBoardListResDto::of));
    }

    @Transactional
    public String removeBoard(Long boardId) {
        Board board = findBoard(boardId);
        board.softDelete();
        return SUCCESS_MESSAGE;
    }

    @Transactional
    public String modifyBoard(Long boardId, SaveBoardReqDto saveBoardReqDto) {
        Board board = findBoard(boardId);
        board.update(saveBoardReqDto.title(), saveBoardReqDto.content());
        return SUCCESS_MESSAGE;
    }

    public Board findBoard(Long boardId) {
        return boardRepository.findByIdAndIsVisible(boardId, true)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_BOARD));
    }
}
