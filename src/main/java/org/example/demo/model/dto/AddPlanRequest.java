package org.example.demo.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.demo.model.Plan;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AddPlanRequest {
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime start;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime end;

    private String category;

    public Plan toEntity(String maker) {
        return Plan.builder()
                .title(title)
                .start(start)
                .end(end)
                .maker(maker)
                .category(category)
                .build();
    }

}
