package org.example.demo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.demo.model.Plan;
import org.example.demo.model.dto.AddPlanRequest;
import org.example.demo.model.dto.UpdatePlanRequest;
import org.example.demo.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name="Swagger-PlanAPI",description = "Swagger-Description")
public class PlanApiController {

    private final PlanService planService;

    @Operation(summary = "Add-New-Plan", description = "Add-Description")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "ADDED"),
            @ApiResponse(responseCode = "400", description = "X")
    })
    @PostMapping("/api/plan")
    public ResponseEntity<Plan> addPlan(@RequestBody AddPlanRequest request, Principal principal) {
        Plan savePlan = planService.save(request, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savePlan);
    }

    @Operation(summary = "Add-Plans-4Week", description = "Add-Description")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "ADDED"),
            @ApiResponse(responseCode = "400", description = "X")
    })
    @PostMapping("/api/plans")
    public ResponseEntity<List<Plan>> addPlans(@RequestBody AddPlanRequest request, Principal principal) {
        List<Plan> savedPlans = planService.saveAllWeek(request,principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlans);
    }

    @Operation(summary = "Update-Plan",description = "Update-Description")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "UPDATED"),
            @ApiResponse(responseCode = "400", description = "X")
    })
    @PutMapping("/api/plan/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable long id,
                                           @RequestBody UpdatePlanRequest request) {
        Plan updatedPlan = planService.update(id, request);

        return ResponseEntity.ok().body(updatedPlan);
    }

    @Operation(summary = "Delete-Plan",description = "Delete-Description")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "DELETED"),
            @ApiResponse(responseCode = "400", description = "X")
    })
    @DeleteMapping("/api/plan/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        planService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
