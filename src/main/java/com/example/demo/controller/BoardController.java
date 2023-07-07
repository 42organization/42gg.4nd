package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "Write a post";
    }

    @PostMapping("/board/write")
    public String boardWritePro(Board board) {
        boardService.write(board);
        System.out.println(board.getTitle());
        System.out.println(board.getContent());
        return "Upload Success";
    }

    @GetMapping("/board/list")
    public List<Board> boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        List<Board> list = boardService.boardList();
        return list;
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {
        Board boardTemp = boardService.boardView(id);
        System.out.println(boardTemp.getId());
        System.out.println(boardTemp.getTitle());
        System.out.println(boardTemp.getContent());
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());
        System.out.println(boardTemp.getTitle());
        System.out.println(boardTemp.getContent());
        boardService.write(boardTemp);
        return "Successfully updated";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "Successfully deleted";
    }

}
