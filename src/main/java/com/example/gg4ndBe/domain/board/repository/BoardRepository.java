package com.example.gg4ndBe.domain.board.repository;

import com.example.gg4ndBe.domain.board.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByIdAndIsVisible(Long id, Boolean isVisible);

    Page<Board> findAllByIsVisible(Pageable pageable, Boolean isVisible);
}
