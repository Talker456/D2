package org.example.demo.model.dto;

import lombok.Getter;
import org.example.demo.model.Plan;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class PlanListViewResponse {
    private final Long id;
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String maker;
    private final Long duration;
    private final String category;

    public PlanListViewResponse(Plan plan) {
        id = plan.getId();
        title = plan.getTitle();
        start = plan.getStart();
        end = plan.getEnd();
        maker = plan.getMaker();
        duration = Duration.between(start, end).toMinutes();
        category = plan.getCategory();
    }

}
