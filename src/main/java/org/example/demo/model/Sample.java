package org.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
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

    @Builder(access = AccessLevel.PRIVATE)
    private Sample(String text) {
        this.text = text;
    }

    public static Sample toEntity(String text) {
        return Sample.builder()
            .text(text)
            .build();
    }

}
