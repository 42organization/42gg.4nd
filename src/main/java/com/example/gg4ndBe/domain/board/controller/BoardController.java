package com.example.gg4ndBe.domain.board.controller;

import com.example.gg4ndBe.common.dto.PageResponse;
import com.example.gg4ndBe.domain.board.dto.BoardDto.*;
import com.example.gg4ndBe.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {
    private final BoardService boardService;

    @PostMapping()
    public ResponseEntity<String> addBoard(@RequestBody SaveBoardReqDto saveBoardReqDto){
        return ResponseEntity.ok(boardService.addBoard(saveBoardReqDto));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<GetBoardDetailResDto> getBoardDetail(@PathVariable("boardId") Long boardId){
        return ResponseEntity.ok(boardService.getBoardDetail(boardId));
    }

    @GetMapping("")
    public ResponseEntity<PageResponse<GetBoardListResDto>> getBoardList(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(boardService.getBoardList(pageable));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> removeBoard(@PathVariable("boardId") Long boardId){
        return ResponseEntity.ok(boardService.removeBoard(boardId));
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<String> modifyBoard(
            @PathVariable("boardId") Long boardId,
            @RequestBody SaveBoardReqDto saveBoardReqDto
    ){
        return ResponseEntity.ok(boardService.modifyBoard(boardId, saveBoardReqDto));
    }
}
