package org.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(
        name = "PLAN_GENERATOR",
        sequenceName = "PLAN_ID_SEQ",
        initialValue = 1, allocationSize = 1
)
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAN_GENERATOR")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_time",nullable = false)
    private LocalDateTime start;

    @Column(name="end_time",nullable = false)
    private LocalDateTime end;

    @Column(name="maker",nullable = false)
    private String maker;

    @Column(name="created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name="category")
    private String category;

    @Builder
    private Plan(String title, LocalDateTime start, LocalDateTime end, String maker,String category) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.maker = maker;
        this.category=category;
    }

    public void update(String title,LocalDateTime start, LocalDateTime end,String category) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.category=category;
    }
}
