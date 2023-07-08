package onboarding.gg.controller;

import lombok.AllArgsConstructor;
import onboarding.gg.dto.BoardDto;
import onboarding.gg.service.BoardService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    /* 게시글 목록 */
    @GetMapping("/")
    public String list() {
        List<BoardDto> boardList = boardService.getBoardlist();
        return boardList.toString();
    }
    @GetMapping("/{no}")
    public String postView(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);
        model.addAttribute("boardDto", boardDTO);
        return model.toString();
    }

    /* 게시글 추가*/
    @GetMapping("/post")
    public String write() {
        return "board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        System.out.println("boardDto = " + boardDto);
        return "redirect:/";
    }

    /* 게시글 수정 */
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);
        model.addAttribute("boardDto", boardDTO);
        return model.toString();
    }

    @PutMapping("/post/edit/{no}")
    public String update(@PathVariable Long no, @RequestBody BoardDto boardDTO) {
        boardService.updatePost(no, boardDTO);
        return "redirect:/";
    }

    /* 게시글 삭제 */
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }
}
