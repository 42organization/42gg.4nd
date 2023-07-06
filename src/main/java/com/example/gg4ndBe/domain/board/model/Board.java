package com.example.gg4ndBe.domain.board.model;

import com.example.gg4ndBe.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;
    @Column(length = 1000)
    private String content;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
