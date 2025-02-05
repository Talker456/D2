package org.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo.model.dto.PlanListViewResponse;
import org.example.demo.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PlanViewController {
    private final PlanService planService;

    @GetMapping("/plans")
    public String getPlans(Model model) {
        List<PlanListViewResponse> plans = planService.findAll()
                .stream()
                .map(PlanListViewResponse::new)
                .toList();
        model.addAttribute("plans", plans);
        return "plans";
    }
}
