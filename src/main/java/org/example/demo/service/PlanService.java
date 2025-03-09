package org.example.demo.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.demo.model.Plan;
import org.example.demo.model.dto.AddPlanRequest;
import org.example.demo.model.dto.PlanCategoryCountResponse;
import org.example.demo.model.dto.PlanListViewResponse;
import org.example.demo.model.dto.UpdatePlanRequest;
import org.example.demo.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public List<Plan> findAll(){
        return planRepository.findAll();
    }

    public Plan save(AddPlanRequest request, String maker) {
        return planRepository.save(request.toEntity(maker));
    }

    public List<Plan> saveAllWeek(AddPlanRequest request, String maker) {
        List<Plan> plans;

        Plan second = AddPlanRequest.builder()
                .title(request.getTitle())
                .start(request.getStart().plusDays(7))
                .end(request.getEnd().plusDays(7))
                .category(request.getCategory())
                .build()
                .toEntity(maker);

        Plan third = AddPlanRequest.builder()
                .title(request.getTitle())
                .start(request.getStart().plusDays(14))
                .end(request.getEnd().plusDays(14))
                .category(request.getCategory())
                .build()
                .toEntity(maker);

        Plan fourth = AddPlanRequest.builder()
                .title(request.getTitle())
                .start(request.getStart().plusDays(21))
                .end(request.getEnd().plusDays(21))
                .category(request.getCategory())
                .build()
                .toEntity(maker);

        plans = List.of(request.toEntity(maker), second, third, fourth);

        return planRepository.saveAll(plans);
    }

    public void delete(long id) {
        planRepository.deleteById(id);
    }

    @Transactional
    public Plan update(long id, UpdatePlanRequest request) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        plan.update(request.getTitle(), request.getStart(), request.getEnd(),request.getCategory());

        return plan;
    }

    public List<Plan> findAllByUsername(String username) {
        return planRepository.findByMaker(username);
    }

    public List<Plan> findAllByMakerOrderByStart(String username){
        return planRepository.findByMakerOrderByStart(username);
    }

    public List<PlanCategoryCountResponse> findCategoryCounts(String username){
        return planRepository.findCategories(username);
    }

    public List<Plan> findWeeklyPlans(String username,LocalDateTime start,LocalDateTime end){
        return planRepository.findWeeklyPlans(username, start, end);
    }
}
