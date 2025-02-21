package org.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.demo.model.Plan;

@Getter
@AllArgsConstructor
public class PlanCategoryCountResponse {
    String category;
    Long count;

}
