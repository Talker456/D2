package org.example.demo.repository;

import org.example.demo.model.Plan;
import org.example.demo.model.dto.PlanCategoryCountResponse;
import org.example.demo.model.dto.PlanListViewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByMaker(String username);

    List<Plan> findByMakerOrderByStart(String username);

    @Query("SELECT "
            + "new org.example.demo.model.dto.PlanCategoryCountResponse(IFNULL(p.category,'null'), COUNT(p.id)) "
            + "FROM Plan p "
            + "WHERE p.maker = :maker "
            + "GROUP BY p.category")
    List<PlanCategoryCountResponse> findCategories(@Param("maker") String maker);

    @Query("SELECT p from Plan p "
            + "WHERE p.maker = :maker "
            + "AND p.start between :start and :end "
            + "ORDER BY start")
    List<Plan> findWeeklyPlans(@Param("maker") String maker, LocalDateTime start, LocalDateTime end);


}
