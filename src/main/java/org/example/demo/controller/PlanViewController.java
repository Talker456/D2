package org.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo.model.dto.PlanCategoryCountResponse;
import org.example.demo.model.dto.PlanListViewResponse;
import org.example.demo.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PlanViewController {
    private final PlanService planService;
    private final Logger logger = LoggerFactory.getLogger(PlanViewController.class);

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

    @GetMapping("/planner")
    public String getPlanner(Model model, Principal principal) {
        LocalDateTime now = LocalDateTime.now();
        int day = now.getDayOfWeek().get(ChronoField.DAY_OF_WEEK);

        int diff = 7 - day;

        LocalDateTime end = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 23, 59, 59);
        end = end.plusDays(diff);
        LocalDateTime start = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 0, 0, 0);
        start = start.minusDays(6);

        List<PlanListViewResponse> plans = planService.findWeeklyPlans(principal.getName(),start,end)
                .stream()
                .map(PlanListViewResponse::new)
                .toList();

        model.addAttribute("weeklyPlans", plans);
        model.addAttribute("startOfWeek", start);
        return "planner";
    }

    @GetMapping("/planner2")
    public String getPlanner2(Model model, Principal principal) {
        LocalDateTime now = LocalDateTime.now();
        int day = now.getDayOfWeek().get(ChronoField.DAY_OF_WEEK);

        int diff = 7 - day;

        LocalDateTime end = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 23, 59, 59);
        end = end.plusDays(diff);
        LocalDateTime start = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 0, 0, 0);
        start = start.minusDays(6);

        List<PlanListViewResponse> plans = planService.findWeeklyPlans(principal.getName(),start,end)
                .stream()
                .map(PlanListViewResponse::new)
                .toList();

        List<LocalDateTime> week = List.of(start, start.plusDays(1), start.plusDays(2), start.plusDays(3),
                start.plusDays(4), start.plusDays(5), start.plusDays(6));

        model.addAttribute("weeklyPlans", plans);
        model.addAttribute("weeks", week);
        return "planner2";
    }
}
