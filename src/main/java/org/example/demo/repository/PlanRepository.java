package org.example.demo.repository;

import org.example.demo.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByMaker(String username);

    List<Plan> findByMakerOrderByStart(String username);
}
