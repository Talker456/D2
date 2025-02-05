package org.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo.model.Plan;
import org.example.demo.model.dto.AddPlanRequest;
import org.example.demo.model.dto.UpdatePlanRequest;
import org.example.demo.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class PlanApiController {

    private final PlanService planService;

    @PostMapping("/api/plan")
    public ResponseEntity<Plan> addPlan(@RequestBody AddPlanRequest request, Principal principal) {
        Plan savePlan = planService.save(request, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savePlan);

    }

    @PutMapping("/api/plan/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable long id,
                                           @RequestBody UpdatePlanRequest request) {
        Plan updatedPlan = planService.update(id, request);

        return ResponseEntity.ok().body(updatedPlan);
    }

    @DeleteMapping("/api/plan/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        planService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
