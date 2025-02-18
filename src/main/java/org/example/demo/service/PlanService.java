package org.example.demo.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.demo.model.Plan;
import org.example.demo.model.dto.AddPlanRequest;
import org.example.demo.model.dto.UpdatePlanRequest;
import org.example.demo.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
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

    public void delete(long id) {
        planRepository.deleteById(id);
    }

    @Transactional
    public Plan update(long id, UpdatePlanRequest request) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        plan.update(request.getTitle(), request.getStart(), request.getEnd());

        return plan;
    }

    public List<Plan> findAllByUsername(String username) {
        return planRepository.findByMaker(username);
    }

    public List<Plan> findAllByMakerOrderByStart(String username){
        return planRepository.findByMakerOrderByStart(username);
    }
}
