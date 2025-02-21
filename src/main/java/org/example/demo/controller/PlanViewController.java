package org.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo.model.dto.PlanCategoryCountResponse;
import org.example.demo.model.dto.PlanListViewResponse;
import org.example.demo.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PlanViewController {
    private final PlanService planService;

    @GetMapping("/plans")
    public String getPlans(Model model, Principal principal) {
        List<PlanListViewResponse> plans = planService.findAllByUsername(principal.getName())
                .stream()
                .map(PlanListViewResponse::new)
                .toList();
        model.addAttribute("plans", plans);

        List<PlanListViewResponse> sortedPlans = planService.findAllByMakerOrderByStart(principal.getName())
                .stream()
                .map(PlanListViewResponse::new)
                .toList();
        model.addAttribute("sortedPlans", sortedPlans);
        return "plans";
    }

    @GetMapping("/stats")
    public String getStats(Model model, Principal principal) {
        List<PlanCategoryCountResponse> list = planService.findCategoryCounts(principal.getName());
        model.addAttribute("counts", list);
        return "stats";
    }
}
