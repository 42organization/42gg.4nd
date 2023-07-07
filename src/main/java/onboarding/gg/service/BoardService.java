package onboarding.gg.service;


import lombok.AllArgsConstructor;
import onboarding.gg.dto.BoardDto;
import onboarding.gg.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}