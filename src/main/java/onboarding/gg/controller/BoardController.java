package onboarding.gg.controller;

import lombok.AllArgsConstructor;
import onboarding.gg.dto.BoardDto;
import onboarding.gg.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String list() {
        return "board/list";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        System.out.println("boardDto = " + boardDto);
        return "redirect: /";
    }
}
