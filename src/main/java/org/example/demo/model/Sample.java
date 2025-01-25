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
        name = "SAMPLE_GENERATOR",
        sequenceName = "ID_SEQ",
        initialValue = 1, allocationSize = 1
)
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAMPLE_GENERATOR")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name="created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    private Sample(String text) {
        this.text = text;
    }

//    public static Sample toEntity(String text) {
//        return Sample.builder()
//            .text(text)
//            .build();
//    }

}
